package com.vetnelliFront.vetnelliFront.dto;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.boot.micrometer.observation.autoconfigure.ObservationProperties.Http;
import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
    
    private final int status;
    private final String message;
    private Map<String,String> errors;
    private final LocalDateTime timestamp;

    public static ErrorResponse de (HttpStatus httpsStatus, String msg){
        return ErrorResponse.builder().
        status(httpsStatus.value()).
        message(msg).
        timestamp(LocalDateTime.now()).build();

    }

    public static ErrorResponse deValidacao (HttpStatus httpsStatus, Map<String, String> errors){
        return ErrorResponse.builder().
        status(httpsStatus.value()).
        message("Erro de Validação").
        errors(errors).
        timestamp(LocalDateTime.now()).build();
    }
}
