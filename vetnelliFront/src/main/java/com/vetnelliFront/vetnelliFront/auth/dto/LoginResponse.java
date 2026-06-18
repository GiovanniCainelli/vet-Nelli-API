package com.vetnelliFront.vetnelliFront.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class LoginResponse {
    private String nome;
    private String senha;
    private String email;
}
