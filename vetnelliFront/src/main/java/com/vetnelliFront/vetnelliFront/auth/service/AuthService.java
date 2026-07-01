package com.vetnelliFront.vetnelliFront.auth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.vetnelliFront.vetnelliFront.auth.dto.LoginRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.LoginResponse;
import com.vetnelliFront.vetnelliFront.security.service.JwtService;
import com.vetnelliFront.vetnelliFront.security.service.UsuarioDetailsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioDetailsService usuarioDetailsService;

    public LoginResponse login(LoginRequest request) { // autentico
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha()));
        UserDetails userDetails = usuarioDetailsService.loadUserByUsername(request.getEmail()); // trago o usuario
        String token = jwtService.gerarToken(userDetails);

        return LoginResponse.builder().token(token).build();
    }

}
