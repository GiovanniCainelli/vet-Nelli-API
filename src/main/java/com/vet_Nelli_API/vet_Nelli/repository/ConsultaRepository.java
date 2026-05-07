package com.vet_Nelli_API.vet_Nelli.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.vet_Nelli_API.vet_Nelli.model.Consulta;

@Repository
public interface ConsultaRepository extends MongoRepository<Consulta, String> {

}
