package com.vetnelliFront.vetnelliFront.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vetnelliFront.vetnelliFront.dto.ConsultaRequest;
import com.vetnelliFront.vetnelliFront.dto.ConsultaResponse;
import com.vetnelliFront.vetnelliFront.entity.ConsultaEntity;
import com.vetnelliFront.vetnelliFront.enums.Status;

@Component
public class ConsultaMapper {

    public ConsultaEntity toEntity(ConsultaRequest request) {

        return ConsultaEntity.builder().nomePet(request.getNomePet()).idadePet(request.getIdadePet())
                .nomeDono(request.getNomeDono()).motivo(request.getMotivo()).dataConsulta(request.getDataConsulta())
                .status(Status.AGENDADA).build();

    }

    public ConsultaResponse toResponse(ConsultaEntity entity) {
        return ConsultaResponse.builder().id(entity.getId()).nomePet(entity.getNomePet()).idadePet(entity.getIdadePet())
                .nomeDono(entity.getNomeDono()).motivo(entity.getMotivo()).dataConsulta(entity.getDataConsulta())
                .status(entity.getStatus()).build();

    }

    

    public List<ConsultaResponse> toResponseList(List<ConsultaEntity> entity) {

        return entity.stream().map(this::toResponse).toList();
    }

    public void toUpdateEntity(ConsultaEntity entity, ConsultaRequest request) {
        entity.setNomePet(request.getNomePet());
        entity.setNomeDono(request.getNomeDono());
        entity.setDataConsulta(request.getDataConsulta());
        entity.setIdadePet(request.getIdadePet());
        entity.setMotivo(request.getMotivo());

    }

}
