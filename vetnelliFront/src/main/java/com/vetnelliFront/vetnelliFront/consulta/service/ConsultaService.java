package com.vetnelliFront.vetnelliFront.consulta.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;
import com.vetnelliFront.vetnelliFront.consulta.enums.Status;
import com.vetnelliFront.vetnelliFront.consulta.exception.ConsultaException;
import com.vetnelliFront.vetnelliFront.consulta.exception.NotFoundException;
import com.vetnelliFront.vetnelliFront.consulta.repository.ConsultaRepository;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    private void validarData(ConsultaEntity entity) {
        if (entity.getDataConsulta().isBefore(LocalDateTime.now().plusMinutes(1))) {
            throw new ConsultaException("Data da consulta inválida");
        }
    }

    public ConsultaEntity buscarConsultaId(String id) {

        ConsultaEntity consultaBuscada = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado"));
        return (consultaBuscada);
    }

    public List<ConsultaEntity> buscarConsultas() {
        List<ConsultaEntity> listaConsulta = repository.findAll();

        return listaConsulta;
    }

    public ConsultaEntity cadastrarConsulta(ConsultaEntity consultaEntity) {

        validarData(consultaEntity);

        return repository.save(consultaEntity);
    }

    public ConsultaEntity atualizarConsulta(ConsultaEntity consultaEntity) {

        validarData(consultaEntity);

        return repository.save(consultaEntity);

    }

    public void deletarConsulta(String id) {
        ConsultaEntity consultaBuscada = buscarConsultaId(id);
        repository.delete(consultaBuscada);
    }

    public ConsultaEntity atualizarStatusConsulta(String id, Status status) {
        ConsultaEntity consultaBuscada = buscarConsultaId(id);

        Status statusAtual = consultaBuscada.getStatus();

        boolean transicaoValida = (statusAtual == Status.AGENDADA && status == Status.EM_ATENDIMENTO) ||
                (statusAtual == Status.EM_ATENDIMENTO && status == Status.FINALIZADA || statusAtual == status);

        if (!transicaoValida) {
            throw new ConsultaException(
                    "Transição inválida: " + statusAtual + " → " + status);
        }

        

        consultaBuscada.setStatus(status);
        return repository.save(consultaBuscada);
    }

}
