package com.vetnelliFront.vetnelliFront.mapper;

import org.mapstruct.Mapper;

import com.vetnelliFront.vetnelliFront.auth.dto.LoginRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.LoginResponse;
import com.vetnelliFront.vetnelliFront.consulta.dto.ConsultaRequest;
import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    public LoginResponse toResponse(ConsultaEntity entity);

    public LoginRequest toEntity(ConsultaRequest request);

    
}
