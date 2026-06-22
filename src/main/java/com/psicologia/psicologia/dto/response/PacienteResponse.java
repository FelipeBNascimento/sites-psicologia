package com.psicologia.psicologia.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String mensagem;
    private LocalDate data;
}
