package com.vetnelliFront.vetnelliFront.consulta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetnelliFront.vetnelliFront.consulta.dto.ConsultaRequest;
import com.vetnelliFront.vetnelliFront.consulta.dto.ConsultaResponse;
import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;
import com.vetnelliFront.vetnelliFront.consulta.service.ConsultaService;
import com.vetnelliFront.vetnelliFront.enums.Status;
import com.vetnelliFront.vetnelliFront.mapper.ConsultaMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService service;
    private final ConsultaMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> buscarConsultaPorId(@PathVariable String id) {
        return ResponseEntity.ok(mapper.toResponse(service.buscarConsultaId(id)));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> buscarConsultas() {
        return ResponseEntity.ok(mapper.toResponseList(service.buscarConsultas()));
    }

    @PostMapping
    public ResponseEntity<ConsultaResponse> cadastrarConsulta(@Valid @RequestBody ConsultaRequest request) {

        ConsultaEntity consultaSalva = mapper.toEntity(request);

        consultaSalva = service.cadastrarConsulta(consultaSalva);

        URI uri = URI.create("/consultas/" + consultaSalva.getId());

        return ResponseEntity.created(uri).body(mapper.toResponse(consultaSalva));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> atualizarConsulta(@PathVariable String id,
            @Valid @RequestBody ConsultaRequest request) {

        ConsultaEntity consultaBuscada = service.buscarConsultaId(id);
        mapper.toUpdateEntity(consultaBuscada, request);
        ConsultaEntity consultaAtualizada = service.atualizarConsulta(consultaBuscada);

        return ResponseEntity.ok(mapper.toResponse(consultaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable String id) {
        service.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ConsultaResponse> atualizarStatusConsulta(@PathVariable String id,
            @RequestParam Status status) {
        return ResponseEntity.ok(mapper.toResponse(service.atualizarStatusConsulta(id, status)));
    }

}
