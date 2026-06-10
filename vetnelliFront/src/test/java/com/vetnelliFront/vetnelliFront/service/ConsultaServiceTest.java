package com.vetnelliFront.vetnelliFront.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vetnelliFront.vetnelliFront.consulta.entity.ConsultaEntity;
import com.vetnelliFront.vetnelliFront.consulta.exception.ConsultaException;
import com.vetnelliFront.vetnelliFront.consulta.exception.NotFoundException;
import com.vetnelliFront.vetnelliFront.consulta.repository.ConsultaRepository;
import com.vetnelliFront.vetnelliFront.consulta.service.ConsultaService;

@ExtendWith(MockitoExtension.class)
public class ConsultaServiceTest {

    @Mock
    ConsultaRepository repository;

    @InjectMocks
    ConsultaService service;

    @Test
    void deveLancarExceptionQuandoIdNaoEncontrado() {
        when(repository.findById("id-inválido")).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.buscarConsultaId("id-inválido"));
    }

    @Test
    void deveBuscarQuandoIdValido() {
        ConsultaEntity consulta = ConsultaEntity.builder().id("123").nomePet("lasanha").build();

        when(repository.findById("123")).thenReturn(Optional.of(consulta));

        ConsultaEntity teste = service.buscarConsultaId("123");

        assertEquals("123", teste.getId());
        assertEquals("lasanha", teste.getNomePet());

    }

    @Test
    void deveLancarExceptionQuandoDataInvalida() {

        // Arrange
        ConsultaEntity consulta = ConsultaEntity.builder().dataConsulta(LocalDateTime.now().minusDays(1))
                .nomePet("lasnha")
                .build();

        // act + assert
        assertThrows(ConsultaException.class, () -> service.cadastrarConsulta(consulta));
    }

    @Test
    void deveCadastrarQuandoDataValida() {

        // arrange
        ConsultaEntity consulta = ConsultaEntity.builder().dataConsulta(LocalDateTime.now().plusDays(1))
                .nomePet("Lasanha")
                .build();

        when(repository.save(consulta)).thenReturn(consulta);

        // act
        service.cadastrarConsulta(consulta);

        // assert
        verify(repository).save(consulta);

    }

    @Test
    void deveSalvarConsultaAtualizada() {
        ConsultaEntity consulta = ConsultaEntity.builder()
                .id("123")
                .nomePet("Rex")
                .dataConsulta(LocalDateTime.now().plusDays(1)) // data válida
                .build();

        when(repository.save(consulta)).thenReturn(consulta);

        // ACT
        service.atualizarConsulta(consulta);

        // ASSERT
        verify(repository).save(consulta);
    }

    @Test
    void deveLancarExceptionQuandoDataInvalidaAtualizar() {
        ConsultaEntity consulta = ConsultaEntity.builder().id("123").nomePet("Lasanha")
                .dataConsulta(LocalDateTime.now().minusDays(1)).build();

        assertThrows(ConsultaException.class, () -> service.atualizarConsulta(consulta));
    }

    @Test
    void deveLancarExceptionQuandoIdInvalidoDeletar() {
        when(repository.findById("id-inválido")).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> service.deletarConsulta("id-inválido"));
    }

    @Test
    void deveDeletarQuandoIdValido() {

        ConsultaEntity consulta = ConsultaEntity.builder().id("123").nomePet("Lasanha")
                .build();

        when(repository.findById("123")).thenReturn(Optional.of(consulta));

        service.deletarConsulta("123");

        verify(repository).delete(consulta);
    }

    @Test
    void deveLancarExceptionQuandoIdInvalidoAtualizar() {

        ConsultaEntity consultaEntity = ConsultaEntity.builder().id("id-inválido").build();

        assertThrows(NotFoundException.class, () -> service.atualizarConsulta(consultaEntity));
    }

    @Test
    void deveAtualizarQuandoIdValido() {
        ConsultaEntity consultaEntity = ConsultaEntity.builder().id("123").nomePet("lasanha")
                .build();

        when(repository.findById("123")).thenReturn(Optional.of(consultaEntity));

        consultaEntity.setNomePet("lasanha");

        service.atualizarConsulta(consultaEntity);

        verify(repository).save(consultaEntity);
    }

}