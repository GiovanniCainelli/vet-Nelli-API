package com.vetnelliFront.vetnelliFront.usuario.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vetnelliFront.vetnelliFront.usuario.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UsuarioDetailsService implements UserDetailsService{
    

    private final UsuarioRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        return repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuário Nào Encontrado"));
    }
}
