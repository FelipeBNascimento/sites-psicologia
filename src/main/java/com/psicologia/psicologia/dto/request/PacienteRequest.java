package com.psicologia.psicologia.dto.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteRequest {

    @NotBlank(message = "O nome não pode vazio")
    private String nome;
    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "insira um email válido")
    private String email;
    @NotBlank(message = "O telefone não pode estar em branco")
    @Size(max = 15)
    private String telefone;
    @Size(max = 500, message = "A mensagem tem que ter no máximo 500 caracters")
    private String mensagem;
}
