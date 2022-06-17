package com.dzcode.springboot.masterclass.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dzcode.springboot.masterclass.dto.JwtResponse;
import com.dzcode.springboot.masterclass.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
@RequiredArgsConstructor
public class JwtUtils {

    private final JwtConfig jwtConfig;

    public String parseJwt(HttpServletRequest request) {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring("Bearer ".length());
        }
        return null;
    }

    public Boolean isProtectedRoute(HttpServletRequest request) {
        String loginPath = jwtConfig.getLoginPath();
        String refreshTokenPath = jwtConfig.getRefreshTokenPath();
        return !(request.getServletPath().equals(loginPath) || request.getServletPath().equals(refreshTokenPath));
    }

    public DecodedJWT validateJwt(String token) {
        Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret().getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }

    public Collection<SimpleGrantedAuthority> getGrantedAuthorities(DecodedJWT decodedJWT) {
        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        stream(roles).forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role));
        });
        return authorities;
    }

    public JwtResponse generateJwt(HttpServletRequest request, User user) {
        Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret().getBytes());
        String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtConfig.getAccessTokenExpiration()))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);
        String refreshToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtConfig.getRefreshTokenExpiration()))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);

        return new JwtResponse(accessToken, refreshToken, jwtConfig.getAccessTokenExpiration());
    }

    public JwtResponse generateAccessToken(HttpServletRequest request, com.dzcode.springboot.masterclass.model.User user, String refreshToken) {
        Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret().getBytes());
        String accessToken = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtConfig.getAccessTokenExpiration()))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                .sign(algorithm);
        return new JwtResponse(accessToken, refreshToken, jwtConfig.getAccessTokenExpiration());
    }
}
