package com.vetnelliFront.vetnelliFront.auth.service;


import java.util.Optional;

import com.vetnelliFront.vetnelliFront.usuario.entity.UsuarioEntity;


import com.vetnelliFront.vetnelliFront.usuario.service.UsuarioService;

public class AuthService {

    private final UsuarioService service;

    public AuthService(UsuarioService service){
        this.service = service;
    }


    
    



}