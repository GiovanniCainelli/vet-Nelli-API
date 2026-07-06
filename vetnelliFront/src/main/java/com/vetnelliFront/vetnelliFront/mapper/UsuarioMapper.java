package com.vetnelliFront.vetnelliFront.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vetnelliFront.vetnelliFront.auth.dto.RegistrarRequest;
import com.vetnelliFront.vetnelliFront.auth.dto.RegistrarResponse;
import com.vetnelliFront.vetnelliFront.usuario.entity.UsuarioEntity;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id",  ignore = true)
    UsuarioEntity toEntity(RegistrarRequest request);

    @Mapping(target = "token", ignore = true)
    RegistrarResponse toResponse(UsuarioEntity entity);
    
}
