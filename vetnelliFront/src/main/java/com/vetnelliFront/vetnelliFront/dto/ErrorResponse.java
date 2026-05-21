package com.vetnelliFront.vetnelliFront.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
    
    private final int status;
    private final String message;
    private final LocalDateTime timestamp;

    public static ErrorResponse de (HttpStatus httpsStatus, String msg){
        return ErrorResponse.builder().
        status(httpsStatus.value()).
        message(msg).
        timestamp(LocalDateTime.now()).build();

    }
}
