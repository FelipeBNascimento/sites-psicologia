package com.psicologia.psicologia.controller;

import com.psicologia.psicologia.dto.request.PacienteRequest;
import com.psicologia.psicologia.dto.response.PacienteResponse;
import com.psicologia.psicologia.service.PacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/pacientes")
@CrossOrigin(origins = "*")

public class PacienteController {

    private final PacienteService service;

    @PostMapping
    ResponseEntity<Void> cadastrarPaciente(@Valid @RequestBody PacienteRequest pacienteRequest) {

        service.cadastrarPaciente(pacienteRequest);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<List<PacienteResponse>> mostrarPacientes(){

        List<PacienteResponse> listaPacientes = service.mostrarTodosPaciente();

        return ResponseEntity.ok(listaPacientes);
    }


}
