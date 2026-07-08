package com.vetnelliFront.vetnelliFront.auth.service;

import com.vetnelliFront.vetnelliFront.usuario.service.UsuarioService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vetnelliFront.vetnelliFront.auth.dto.LoginRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.LoginResponse;

import com.vetnelliFront.vetnelliFront.auth.dto.RegistrarResponse;
import com.vetnelliFront.vetnelliFront.security.service.JwtService;
import com.vetnelliFront.vetnelliFront.security.service.UsuarioDetailsService;
import com.vetnelliFront.vetnelliFront.usuario.entity.UsuarioEntity;

import com.vetnelliFront.vetnelliFront.exception.LoginInvalidoException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UsuarioService service;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioDetailsService usuarioDetailsService;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {

        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha()));
            UserDetails userDetails = usuarioDetailsService.loadUserByUsername(request.getEmail());
            String token = jwtService.gerarToken(userDetails);

            return LoginResponse.builder().token(token).build();
        } catch (BadCredentialsException e) {
            throw new LoginInvalidoException("Email ou Senha Inválidos");
        }

    }

    public RegistrarResponse registrar(UsuarioEntity entity) {
        service.emailExistente(entity.getEmail());

        entity.setSenha(passwordEncoder.encode(entity.getSenha()));
        UsuarioEntity salvo = service.cadastrarUsuario(entity);
        String token = jwtService.gerarToken(salvo);
        return RegistrarResponse.builder()
                .token(token)
                .email(salvo.getEmail())
                .build();
    }

}
