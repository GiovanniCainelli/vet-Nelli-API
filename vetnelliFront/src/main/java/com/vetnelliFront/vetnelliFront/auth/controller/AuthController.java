package com.vetnelliFront.vetnelliFront.auth.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetnelliFront.vetnelliFront.auth.dto.LoginRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.LoginResponse;
import com.vetnelliFront.vetnelliFront.auth.dto.RegistrarRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.RegistrarResponse;
import com.vetnelliFront.vetnelliFront.auth.service.AuthService;
import com.vetnelliFront.vetnelliFront.mapper.UsuarioMapper;
import com.vetnelliFront.vetnelliFront.usuario.entity.UsuarioEntity;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final UsuarioMapper mapper;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<RegistrarResponse> registrar(@Valid @RequestBody RegistrarRequest request) {

        UsuarioEntity entity = mapper.toEntity(request);
        RegistrarResponse response = authService.registrar(entity);
        URI uri = URI.create("/auth/register/" + entity.getId());
        return ResponseEntity.created(uri).body(response);
    }

}
