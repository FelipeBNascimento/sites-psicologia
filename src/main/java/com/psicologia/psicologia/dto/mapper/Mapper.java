package com.psicologia.psicologia.dto.mapper;

import com.psicologia.psicologia.dto.request.PacienteRequest;
import com.psicologia.psicologia.dto.response.PacienteResponse;
import com.psicologia.psicologia.infrastructure.entities.PacienteEntity;
import org.mapstruct.Mapping;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper  {

    // Mapeando o campo id para que não precisa ser convertido ja que nao irei passar
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "data", ignore = true)
    //  Convertendo de um Dto Requesta para uma entity para salvar no banco de dados
    PacienteEntity paraPacienteEntity(PacienteRequest pacienteRequest);

    // Convertendo de uma entity para um dto Response para poder devolver ao usuario
    PacienteResponse paraPacienteResponse(PacienteEntity pacienteEntity);


    List<PacienteResponse> listaPacientesResponse(List<PacienteEntity> pacienteEntities);
}
