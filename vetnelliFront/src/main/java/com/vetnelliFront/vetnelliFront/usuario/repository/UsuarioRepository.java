package com.vetnelliFront.vetnelliFront.usuario.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.vetnelliFront.vetnelliFront.usuario.entity.UsuarioEntity;

import java.util.Optional;

public interface UsuarioRepository  extends MongoRepository<UsuarioEntity,String>{
    Optional<UsuarioEntity> findByEmail(String email);
}
