package com.dzcode.springboot.masterclass.security.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.dzcode.springboot.masterclass.dto.ErrorMessage;
import com.dzcode.springboot.masterclass.security.jwt.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (jwtUtils.isProtectedRoute(request)) {
            try {
                String token = jwtUtils.parseJwt(request);
                if (token != null) {
                    DecodedJWT decodedJWT = jwtUtils.validateJwt(token);
                    String username = decodedJWT.getSubject();
                    Collection<SimpleGrantedAuthority> authorities = jwtUtils.getGrantedAuthorities(decodedJWT);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    filterChain.doFilter(request, response);
                } else {
                    log.error("Authorisation Required");
                    response.setStatus(UNAUTHORIZED.value());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), new ErrorMessage(UNAUTHORIZED.value(), "Authorization Required!"));
                }
            } catch (Exception exception) {
                log.error("Cannot authenticate user: {}", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), new ErrorMessage(FORBIDDEN.value(), exception.getMessage()));
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
