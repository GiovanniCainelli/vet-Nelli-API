package com.vetnelliFront.vetnelliFront.entity;


import com.vetnelliFront.vetnelliFront.enums.Status;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vetnelliFront.vetnelliFront.enums.IdadePet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Consultas" )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultaEntity {
    @Id
    private String id;
    private String nomePet;
    private IdadePet idadePet;
    private String nomeDono;
    private String motivo;
    private LocalDateTime dataConsulta;
    private Status status;
}
