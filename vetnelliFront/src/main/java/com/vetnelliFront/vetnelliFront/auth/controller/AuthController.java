package com.vetnelliFront.vetnelliFront.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vetnelliFront.vetnelliFront.auth.dto.LoginRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.LoginResponse;
import com.vetnelliFront.vetnelliFront.auth.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestControllerAdvice
@RequestMapping("/auth")
@Controller 
@RequiredArgsConstructor
public class AuthController {// crio um post devolvendo login response, valido o request nos parametros e utilizo o metodo de login. devolvo o ok.
    private final AuthService authService;
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
