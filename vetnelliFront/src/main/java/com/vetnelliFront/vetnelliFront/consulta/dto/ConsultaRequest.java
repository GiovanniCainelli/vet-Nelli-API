package com.vetnelliFront.vetnelliFront.consulta.dto;

import java.time.LocalDateTime;

import com.vetnelliFront.vetnelliFront.consulta.enums.IdadePet;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ConsultaRequest {

    @NotBlank(message = "Nome do pet é obrigatório")
    @Size(min = 2, max = 50, message = "Nome do pet deve ter entre 2 e 50 caracteres")
    private String nomePet;

    @NotNull(message = "Selecione a idade do pet")
    private IdadePet idadePet;

    @NotBlank(message = "Nome do dono é obrigatório")
    @Size(min = 2, max = 50, message = "Nome do dono deve ter entre 2 e 50 caracteres")
    private String nomeDono;

    @NotBlank(message = "Motivo é obrigatório")
    @Size(min = 2, max = 50, message = "Motivo deve ter entre 2 e 50 caracteres")
    private String motivo;

    @NotNull(message = "Data da consulta é obrigatória")
    @Future(message = "Data inválida, não é possível agendar.")
    private LocalDateTime dataConsulta;
}
