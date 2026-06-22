package com.psicologia.psicologia.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TratamentoErros {

    private LocalDateTime dataErro;

    private Integer statusErro;

    private String erro;

    private List<String> mensagens;
}
