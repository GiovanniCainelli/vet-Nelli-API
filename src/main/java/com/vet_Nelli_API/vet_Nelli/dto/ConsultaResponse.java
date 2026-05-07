package com.vet_Nelli_API.vet_Nelli.dto;

import java.time.LocalDateTime;

import com.vet_Nelli_API.vet_Nelli.model.IdadePet;
import com.vet_Nelli_API.vet_Nelli.model.StatusConsulta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaResponse {

    private String id;
    private String nomePet;
    private IdadePet idadePet;
    private String nomeDono;
    private String motivo;
    private LocalDateTime data;
    private StatusConsulta status;

}
