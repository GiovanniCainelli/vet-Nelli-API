package com.vetnelliFront.vetnelliFront.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RegistrarResponse {
    private String token;
    private String email;
    private String senha;
}
