package com.psicologia.psicologia.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.psicologia.psicologia.infrastructure.entities.PacienteEntity;

@Repository
// classe repositorio extendendo jpa para utilizar banco de dados
public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
}
