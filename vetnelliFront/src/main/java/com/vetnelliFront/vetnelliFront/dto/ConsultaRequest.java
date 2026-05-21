package com.vetnelliFront.vetnelliFront.dto;


import java.time.LocalDateTime;

import com.vetnelliFront.vetnelliFront.enums.IdadePet;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ConsultaRequest {
    
    @NotBlank
    @Size(min = 2, max = 50)
    private String nomePet;

    @NotNull
    
    private IdadePet idadePet;

    @NotBlank
    @Size(min = 2, max = 50)
    private String nomeDono;

    @NotBlank
    @Size(min = 2, max = 50)
    private String motivo;

    @Future
    private LocalDateTime dataConsulta;
}
