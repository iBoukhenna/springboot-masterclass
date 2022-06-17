package com.dzcode.springboot.masterclass.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.dzcode.springboot.masterclass.dto.ErrorMessage;
import com.dzcode.springboot.masterclass.dto.JwtResponse;
import com.dzcode.springboot.masterclass.dto.RoleToUserForm;
import com.dzcode.springboot.masterclass.model.Role;
import com.dzcode.springboot.masterclass.model.User;
import com.dzcode.springboot.masterclass.security.jwt.JwtUtils;
import com.dzcode.springboot.masterclass.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @GetMapping("users")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm roleToUserForm) {
        userService.addRoleToUser(roleToUserForm.getUsername(), roleToUserForm.getRolename());
        return ResponseEntity.ok().build();
    }

    @GetMapping("token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String refreshtoken = jwtUtils.parseJwt(request);
            if (refreshtoken != null) {
                DecodedJWT decodedJWT = jwtUtils.validateJwt(refreshtoken);
                String username = decodedJWT.getSubject();
                User user = userService.getUser(username);
                JwtResponse jwtResponse = jwtUtils.generateAccessToken(request, user, refreshtoken);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), jwtResponse);
            } else {
                throw new RuntimeException("Refresh token is missing");
            }
        } catch (Exception exception) {
            response.setStatus(FORBIDDEN.value());
            response.setContentType(APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(response.getOutputStream(), new ErrorMessage(FORBIDDEN.value(), exception.getMessage()));
        }
    }
}
