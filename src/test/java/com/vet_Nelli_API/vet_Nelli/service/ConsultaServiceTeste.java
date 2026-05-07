package com.vet_Nelli_API.vet_Nelli.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.vet_Nelli_API.vet_Nelli.dto.ConsultaRequest;
import com.vet_Nelli_API.vet_Nelli.dto.ConsultaResponse;
import com.vet_Nelli_API.vet_Nelli.exception.ConsultaException;
import com.vet_Nelli_API.vet_Nelli.model.Consulta;
import com.vet_Nelli_API.vet_Nelli.model.IdadePet;
import com.vet_Nelli_API.vet_Nelli.repository.ConsultaRepository;

public class ConsultaServiceTeste {
    private ConsultaRepository repository;
    private ConsultaService service;

    @BeforeEach
    void setup() {
        repository = mock(ConsultaRepository.class);
        service = new ConsultaService(repository);
    }

    @Test
    void dataInvalidaTeste() {
        //Arrange
        ConsultaRequest request = new ConsultaRequest();

        request.setNomePet("Lasanha");
        request.setIdadePet(IdadePet.FILHOTE);
        request.setNomeDono("eve");
        request.setData(LocalDateTime.now().minusDays(1));
        request.setMotivo("vacina");

        // Act + Assert
        assertThrows(ConsultaException.class, () -> {
            service.cadastrarConsulta(request);
        });
    }

    @Test
    void buscarConsultaIdTeste() {

        // Arrange
        Consulta consulta = new Consulta();

        consulta.setId("1");
        consulta.setNomePet("Lasanha");

        when(repository.findById("1")).thenReturn(Optional.of(consulta));

        //Act
        ConsultaResponse response = service.buscarConsultaId("1");

        //Assert
        assertEquals("Lasanha", response.getNomePet());

    }

    @Test
    void buscarConsultasTeste(){

        //Arrange
        Consulta consultaTeste1 = new Consulta();

        consultaTeste1.setId("1");
        consultaTeste1.setNomePet("Lasanha");

        Consulta consultaTeste2 = new Consulta();

        consultaTeste2.setId("2");
        consultaTeste2.setNomePet("fitbill");

        
        
        List<Consulta> listaConsultas = new ArrayList<>();

        listaConsultas.add(consultaTeste1);
        listaConsultas.add(consultaTeste2);

        //Act
        when(repository.findAll()).thenReturn(listaConsultas);

        List<ConsultaResponse> response = service.buscarConsultas();

        //Assert
        assertEquals(2, response.size());
        assertEquals("Lasanha", response.get(0).getNomePet());
        assertEquals("fitbill", response.get(1).getNomePet());



        
        
        


    }



}
