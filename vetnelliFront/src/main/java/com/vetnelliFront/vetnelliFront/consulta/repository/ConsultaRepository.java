package com.vetnelliFront.vetnelliFront.consulta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;

@Repository
public interface ConsultaRepository extends MongoRepository<ConsultaEntity, String> {

}