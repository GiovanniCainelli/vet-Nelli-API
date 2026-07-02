package com.vetnelliFront.vetnelliFront.mapper;

import org.mapstruct.Mapper;

import com.vetnelliFront.vetnelliFront.auth.dto.LoginRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.LoginResponse;
import com.vetnelliFront.vetnelliFront.auth.dto.RegistrarRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.RegistrarResponse;
import com.vetnelliFront.vetnelliFront.consulta.dto.ConsultaRequest;
import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;
import com.vetnelliFront.vetnelliFront.usuario.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioEntity toEntity(RegistrarRequest request);
    RegistrarResponse toResponse(UsuarioEntity entity);


    
}
