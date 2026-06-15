package com.vetnelliFront.vetnelliFront.consulta.dto;

import java.time.LocalDateTime;

import com.vetnelliFront.vetnelliFront.enums.IdadePet;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ConsultaRequest(

        @NotBlank(message = "Nome do pet é obrigatório") @Size(min = 2, max = 50, message = "Nome do pet deve ter entre 2 e 50 caracteres") String nomePet,

        @NotNull(message = "Selecione a idade do pet") IdadePet idadePet,

        @NotBlank(message = "Nome do dono é obrigatório") @Size(min = 2, max = 50, message = "Nome do dono deve ter entre 2 e 50 caracteres") String nomeDono,

        @NotBlank(message = "Motivo é obrigatório") @Size(min = 2, max = 50, message = "Motivo deve ter entre 2 e 50 caracteres") String motivo,

        @NotNull(message = "Data da consulta é obrigatória") @Future(message = "Data inválida, não é possível agendar.") LocalDateTime dataConsulta

) {
}
