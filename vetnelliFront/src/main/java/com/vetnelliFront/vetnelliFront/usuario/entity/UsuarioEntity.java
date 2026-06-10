package com.vetnelliFront.vetnelliFront.usuario.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.vetnelliFront.vetnelliFront.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UsuarioEntity {
    
    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    private Role role;
    
}
