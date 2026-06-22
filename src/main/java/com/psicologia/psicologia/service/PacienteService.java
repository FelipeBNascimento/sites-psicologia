package com.psicologia.psicologia.service;

import com.psicologia.psicologia.dto.mapper.Mapper;
import com.psicologia.psicologia.dto.request.PacienteRequest;
import com.psicologia.psicologia.dto.response.PacienteResponse;
import com.psicologia.psicologia.infrastructure.entities.PacienteEntity;
import com.psicologia.psicologia.infrastructure.repositories.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository repository;
    private final Mapper mapper;
    private final EmailService emailService;

    // metodo privado para cadastrar um paciente utilizando dto
    @Transactional
    public void cadastrarPaciente(PacienteRequest pacienteRequest){

        // utilizadno metodo converter de+to para entity da classse mapper
        PacienteEntity pacienteEntity = mapper.paraPacienteEntity(pacienteRequest);
        // setandando a data como atual
        pacienteEntity.setData(LocalDate.now());

        // Criando metodo para enviar o email
        emailService.enviarNotificacao(pacienteEntity);

        // salvando o paciente no banco de dados
        repository.save(pacienteEntity);
    }


    // mtodo para visualizar lista de pacientes
    public List<PacienteResponse> mostrarTodosPaciente(){

        // buscando todos pacientes no banco de dados
        List<PacienteEntity> pacienteEntities = repository.findAll();

        // retornando a lista de pacientes e ja fazendo a conversao para uma lista response
        return mapper.listaPacientesResponse(pacienteEntities);
    }

}
