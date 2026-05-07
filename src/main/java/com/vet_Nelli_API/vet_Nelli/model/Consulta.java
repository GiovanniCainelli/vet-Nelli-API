package com.vet_Nelli_API.vet_Nelli.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "consultas")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Consulta {

    @Id
    private String id;
    private String nomePet;
    private IdadePet idadePet;
    private String nomeDono;
    private String motivo;
    private LocalDateTime data;
    private StatusConsulta status;
}