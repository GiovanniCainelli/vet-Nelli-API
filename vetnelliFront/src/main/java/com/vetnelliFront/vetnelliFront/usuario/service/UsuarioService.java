package com.vetnelliFront.vetnelliFront.usuario.service;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;
import com.vetnelliFront.vetnelliFront.exception.EmailExistenteException;
import com.vetnelliFront.vetnelliFront.exception.NotFoundException;
import com.vetnelliFront.vetnelliFront.usuario.entity.UsuarioEntity;
import com.vetnelliFront.vetnelliFront.usuario.repository.UsuarioRepository;

import com.vetnelliFront.vetnelliFront.auth.service.AuthService;

// verificar senha ( criar hashCode e Encode)

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final AuthService authService;

    public UsuarioService(UsuarioRepository repository, AuthService authService) {
        this.repository = repository;
        this.authService = authService;
    }

    public UsuarioEntity buscarUsuarioId(String id) {

        UsuarioEntity usuarioBuscado = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado"));
        return (usuarioBuscado);
    }

    public UsuarioEntity buscarUsuarioEmail(String email) {
        UsuarioEntity usuarioBuscado = repository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Email não encontrado."));
        return usuarioBuscado;
    }

    
    public UsuarioEntity cadastrarConsulta(UsuarioEntity usuarioEntity) {
        String email = usuarioEntity.getEmail();
        Optional<UsuarioEntity> usuarioBuscado = authService.emailExisteOptional(email);

        if (usuarioBuscado.isPresent()) {
            throw new EmailExistenteException("Email já existente");
        } else {
            return repository.save(usuarioEntity);
        }

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

}
