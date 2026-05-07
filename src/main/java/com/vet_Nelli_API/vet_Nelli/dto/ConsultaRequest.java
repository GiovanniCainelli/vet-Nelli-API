package com.vet_Nelli_API.vet_Nelli.dto;

import lombok.Data;

import java.time.LocalDateTime;

import com.vet_Nelli_API.vet_Nelli.model.IdadePet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
public class ConsultaRequest {

    @NotBlank(message = "Preencha o Campo Nome do Pet corretamente")
    private String nomePet;

    @NotNull(message = "Preencha o Campo Idade do Pet corretamente")
    private IdadePet idadePet;

    @NotBlank(message = "Preencha o Campo Nome do dono corretamente")
    private String nomeDono;

    @NotBlank(message = "Preencha o Campo Motivo da consulta corretamente")
    private String motivo;

    @NotNull(message = "Selecione uma data Válida")
    private LocalDateTime data;

}