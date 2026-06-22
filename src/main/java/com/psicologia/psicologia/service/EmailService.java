package com.psicologia.psicologia.service;

import com.psicologia.psicologia.infrastructure.entities.PacienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Async
    public void enviarNotificacao(PacienteEntity paciente) {


        // instanciando o simpleMailMesagem para fazer um email simples
        SimpleMailMessage message = new SimpleMailMessage();

        // aqui seria que esta enviando o email
        message.setFrom("felipe.bazanflp3005@gmail.com");

        // aqui seria para qual email esta sendo enviado
        message.setTo("felipe.bazanflp3005@gmail.com");

        // Assunto do email
        message.setSubject("Novo Paciente Cadastrado: " + paciente.getNome());
        // corpo do email
        message.setText("Olá psicologa Paula,\n\nUm novo paciente entrou em contato pelo site:\n" +
                "\nNome: " + paciente.getNome() +
                "\nE-mail: " + paciente.getEmail() +
                "\nTelefone: " + paciente.getTelefone() +
                "\nData: " + paciente.getData() +
                "\n\nMensagem do futuro paciente: " +
                "\n" + paciente.getMensagem() +
                "\n\nAtenciosamente seu assistente virtual");

        javaMailSender.send(message);
    }

}

