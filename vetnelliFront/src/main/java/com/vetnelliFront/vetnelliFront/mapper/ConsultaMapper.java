package com.vetnelliFront.vetnelliFront.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vetnelliFront.vetnelliFront.consulta.dto.ConsultaRequest;
import com.vetnelliFront.vetnelliFront.consulta.dto.ConsultaResponse;
import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;
import com.vetnelliFront.vetnelliFront.enums.Status;

@Component
public class ConsultaMapper {

    public ConsultaEntity toEntity(ConsultaRequest request) {

        return ConsultaEntity.builder().nomePet(request.nomePet()).idadePet(request.idadePet())
                .nomeDono(request.nomeDono()).motivo(request.motivo()).dataConsulta(request.dataConsulta())
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
        entity.setNomePet(request.nomePet());
        entity.setNomeDono(request.nomeDono());
        entity.setDataConsulta(request.dataConsulta());
        entity.setIdadePet(request.idadePet());
        entity.setMotivo(request.motivo());

    }

}
