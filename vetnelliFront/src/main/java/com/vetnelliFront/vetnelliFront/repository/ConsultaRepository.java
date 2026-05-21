package com.vetnelliFront.vetnelliFront.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vetnelliFront.vetnelliFront.entity.ConsultaEntity;

@Repository
public interface ConsultaRepository extends MongoRepository<ConsultaEntity, String> {

}