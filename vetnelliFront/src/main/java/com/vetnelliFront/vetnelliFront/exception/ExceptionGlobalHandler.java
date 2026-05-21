package com.vetnelliFront.vetnelliFront.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vetnelliFront.vetnelliFront.dto.ErrorResponse;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class ExceptionGlobalHandler {

    @ExceptionHandler(ConsultaException.class)
    public ResponseEntity<ErrorResponse> tratarConsultaException(ConsultaException e) {
        return ResponseEntity.badRequest().body(ErrorResponse.de(HttpStatus.BAD_REQUEST,e.getMessage()));

    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> tratarNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.de(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> tratarMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        Map<String, String> erros = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(error -> {
            erros.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(erros);

    }
}
