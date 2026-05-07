package com.vet_Nelli_API.vet_Nelli.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vet_Nelli_API.vet_Nelli.dto.ConsultaRequest;
import com.vet_Nelli_API.vet_Nelli.dto.ConsultaResponse;
import com.vet_Nelli_API.vet_Nelli.exception.ConsultaException;
import com.vet_Nelli_API.vet_Nelli.exception.NotFoundException;
import com.vet_Nelli_API.vet_Nelli.model.Consulta;
import com.vet_Nelli_API.vet_Nelli.model.StatusConsulta;
import com.vet_Nelli_API.vet_Nelli.repository.ConsultaRepository;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public ConsultaResponse toResponse(Consulta c) {
        return new ConsultaResponse(
                c.getId(),
                c.getNomePet(),
                c.getIdadePet(),
                c.getNomeDono(),
                c.getMotivo(),
                c.getData(),
                c.getStatus());
    }

    public ConsultaResponse cadastrarConsulta(ConsultaRequest request) {

        if (request.getData().isBefore(LocalDateTime.now().plusMinutes(1))) {
            throw new ConsultaException("Não é possivél agendar para esta data. Escolha uma Data Posterior");
        } // sem calculo de Fuso-Horario

        Consulta consulta = Consulta.builder()
                .nomePet(request.getNomePet())
                .idadePet(request.getIdadePet())
                .nomeDono(request.getNomeDono())
                .motivo(request.getMotivo())
                .data(request.getData())
                .status(StatusConsulta.AGENDADO).build();

        Consulta objSalvo = repository.save(consulta);

        return toResponse(objSalvo);

    }

    public List<ConsultaResponse> buscarConsultas() {

        List<ConsultaResponse> consultasBuscadas = repository.findAll().stream().map(this::toResponse).toList();

        return consultasBuscadas;

    }

    public ConsultaResponse buscarConsultaId(String id) {
        Consulta consulta = repository.findById(id).orElseThrow(() -> new NotFoundException("Consulta não encontrada"));

        return toResponse(consulta);

    }

    public void deletarConsulta(String id) {
        Consulta consulta = repository.findById(id).orElseThrow(() -> new NotFoundException("Consulta não encontrada"));

        repository.delete(consulta);

    }

    public ConsultaResponse atualizarConsulta(String id, ConsultaRequest request) {

        Consulta consulta = repository.findById(id).orElseThrow(() -> new NotFoundException("Consulta não encontrada"));

        if (request.getData().isBefore(LocalDateTime.now().plusMinutes(1))) {
            throw new ConsultaException("Não é possivél agendar para esta data. Escolha uma Data Posterior");
        } // sem calculo de Fuso-Horario

        consulta.setNomePet(request.getNomePet());
        consulta.setIdadePet(request.getIdadePet());
        consulta.setNomeDono(request.getNomeDono());
        consulta.setData(request.getData());
        consulta.setMotivo(request.getMotivo());

        return toResponse(repository.save(consulta));
    }
}
