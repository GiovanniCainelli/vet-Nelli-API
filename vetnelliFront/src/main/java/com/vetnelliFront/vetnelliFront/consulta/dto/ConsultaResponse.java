package com.vetnelliFront.vetnelliFront.consulta.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.vetnelliFront.vetnelliFront.enums.IdadePet;
import com.vetnelliFront.vetnelliFront.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ConsultaResponse {
    @Id
    private String id;
    private String nomePet;
    private IdadePet idadePet;
    private String nomeDono;
    private String motivo;
    private LocalDateTime dataConsulta;
    private Status status;
}
