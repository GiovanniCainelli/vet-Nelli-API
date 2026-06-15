package com.vetnelliFront.vetnelliFront.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistrarRequest(
        @NotBlank(message = "Nome é obrigatório.") @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres.") String nome,
        @NotBlank(message = "Email é obrigatório.") @Email(message = "Formato de Email inválido") String email,
        @NotBlank(message = "Senha é obrigatória") @Size(min = 6, message = "Senha deve ter no minímo 6 caracteres") String senha) {
}