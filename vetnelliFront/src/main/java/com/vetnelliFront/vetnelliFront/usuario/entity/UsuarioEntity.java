package com.vetnelliFront.vetnelliFront.usuario.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

public class UsuarioEntity implements UserDetails {
    
    @Id
    private String id;
    private String nome;
    private String email;
    private String senha;
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("Role_" + role.name()));
    }
    

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public String getPassword(){
        return senha;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

}
