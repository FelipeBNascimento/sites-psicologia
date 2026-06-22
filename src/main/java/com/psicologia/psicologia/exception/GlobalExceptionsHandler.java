package com.psicologia.psicologia.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<TratamentoErros> tratarErrosValidacao(MethodArgumentNotValidException ex){

        List<String> mensagemErros = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        TratamentoErros tratamentoErros = new TratamentoErros(

                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Erro de validação nos campos",
                mensagemErros
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(tratamentoErros);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<TratamentoErros> tratarErroEmailDuplicado(DataIntegrityViolationException ex) {

        List<String> mensagensErros = Collections.singletonList("Este e-mail já está cadastrado em nosso sistema.");

        TratamentoErros erroResposta = new TratamentoErros(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(), // Status 409 Conflict
                "Registro Duplicado",
                mensagensErros
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(erroResposta);
    }

}
