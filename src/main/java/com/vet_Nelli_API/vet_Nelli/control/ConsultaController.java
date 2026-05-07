package com.vet_Nelli_API.vet_Nelli.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vet_Nelli_API.vet_Nelli.dto.ConsultaRequest;
import com.vet_Nelli_API.vet_Nelli.dto.ConsultaResponse;

import com.vet_Nelli_API.vet_Nelli.service.ConsultaService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;

    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> buscarConsultas() {
        return ResponseEntity.ok(service.buscarConsultas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> buscarConsultaId(@PathVariable String id) {

        return ResponseEntity.ok(service.buscarConsultaId(id));
    }

    @PostMapping
    public ResponseEntity<ConsultaResponse> cadastrarConsulta(@Valid @RequestBody ConsultaRequest consulta) {

        ConsultaResponse novaConsulta = service.cadastrarConsulta(consulta);

        URI uri = URI.create("/consultas/" + novaConsulta.getId());
        return ResponseEntity.created(uri).body(novaConsulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable String id){
        service.deletarConsulta(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> atualizarConsulta( @PathVariable String id, @Valid  @RequestBody  ConsultaRequest request){
        ConsultaResponse consultaAtualizada = service.atualizarConsulta(id, request);

        return ResponseEntity.ok(consultaAtualizada);
    }


}
