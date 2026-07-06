package com.vetnelliFront.vetnelliFront.auth.service;

import com.vetnelliFront.vetnelliFront.usuario.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configurers.PasswordManagementConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vetnelliFront.vetnelliFront.auth.dto.LoginRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.LoginResponse;
import com.vetnelliFront.vetnelliFront.auth.dto.RegistrarRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.RegistrarResponse;
import com.vetnelliFront.vetnelliFront.security.service.JwtService;
import com.vetnelliFront.vetnelliFront.security.service.UsuarioDetailsService;
import com.vetnelliFront.vetnelliFront.usuario.entity.UsuarioEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioDetailsService usuarioDetailsService;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha()));
        UserDetails userDetails = usuarioDetailsService.loadUserByUsername(request.getEmail());
        String token = jwtService.gerarToken(userDetails);

        return LoginResponse.builder().token(token).build();
    }

    public RegistrarResponse registrar(UsuarioEntity entity) {
        entity.setSenha(passwordEncoder.encode(entity.getSenha()));
        UsuarioEntity salvo = usuarioRepository.save(entity);
        String token = jwtService.gerarToken(salvo);
        return RegistrarResponse.builder()
                .token(token)
                .email(salvo.getEmail())
                .build();
    }

}
