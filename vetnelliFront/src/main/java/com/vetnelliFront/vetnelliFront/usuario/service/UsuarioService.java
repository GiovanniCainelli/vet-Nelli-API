package com.vetnelliFront.vetnelliFront.usuario.service;

import org.springframework.stereotype.Service;

import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;
import com.vetnelliFront.vetnelliFront.exception.NotFoundException;
import com.vetnelliFront.vetnelliFront.usuario.entity.UsuarioEntity;
import com.vetnelliFront.vetnelliFront.usuario.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioEntity buscarUsuarioId(String id) {

        UsuarioEntity usuarioBuscado = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado"));
        return (usuarioBuscado);
    }

    public UsuarioEntity cadastrarConsulta(UsuarioEntity usuarioEntity) {
        // validar email (existe e é válido)
        return repository.save(usuarioEntity);
    }

    public UsuarioEntity buscarUsuarioEmail(String email) {
        UsuarioEntity usuarioBuscado = repository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Email não encontrado."));
        return usuarioBuscado;
    }

    public UsuarioEntity atualizarUsuario(String id, UsuarioEntity usuarioEntity) {
        
        UsuarioEntity usuarioBuscado = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
        return usuarioBuscado;
    }

    public void DeletarUsuario(String id) {
        UsuarioEntity usuarioBuscado = buscarUsuarioId(id);
        repository.delete(usuarioBuscado);
    }


    //validar email e se ja existe no sistema
}
