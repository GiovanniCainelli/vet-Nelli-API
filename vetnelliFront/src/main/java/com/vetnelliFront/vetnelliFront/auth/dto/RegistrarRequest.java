package com.vetnelliFront.vetnelliFront.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrarRequest {
    @NotBlank(message = "Nome é obrigatório.")
    @Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 caracteres.")

    private String nome;

    @NotBlank(message = "Email é obrigatório.")
    @Email(message = "Formato de Email inválido")

    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter no minímo 6 caracteres")

    private String senha;
}