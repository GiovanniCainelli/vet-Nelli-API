package com.vetnelliFront.vetnelliFront.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.vetnelliFront.vetnelliFront.consulta.dto.ConsultaRequest;
import com.vetnelliFront.vetnelliFront.consulta.dto.ConsultaResponse;
import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    ConsultaResponse toResponse(ConsultaEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    ConsultaEntity toEntity(ConsultaRequest request);

    List<ConsultaResponse> toResponseList(List<ConsultaEntity> entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    void toUpdateEntity(@MappingTarget ConsultaEntity entity, ConsultaRequest request);
}
