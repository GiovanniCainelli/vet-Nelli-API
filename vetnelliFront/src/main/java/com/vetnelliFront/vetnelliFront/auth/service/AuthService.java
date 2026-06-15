package com.vetnelliFront.vetnelliFront.auth.service;


import java.util.Optional;

import com.vetnelliFront.vetnelliFront.usuario.entity.UsuarioEntity;

import com.vetnelliFront.vetnelliFront.usuario.repository.UsuarioRepository;

public class AuthService {

    private final UsuarioRepository repository;

    public AuthService(UsuarioRepository repository){
        this.repository = repository;
    }


    public Optional<UsuarioEntity> emailExisteOptional(String email) {
        Optional<UsuarioEntity> usuarioBuscado = repository.findByEmail(email);

        return usuarioBuscado;
    }

    



}