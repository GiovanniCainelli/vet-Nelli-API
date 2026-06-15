package com.vetnelliFront.vetnelliFront.consulta;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;


public interface ConsultaRepository extends MongoRepository<ConsultaEntity, String> {

}