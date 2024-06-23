package com.SistemaDeEmails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication // Indica que é a classe principal do projeto spring
@EnableScheduling // Habilita o agendamento de tarefas.
public class SistemaDeEmails {
    public static void main(String[] args) {
        SpringApplication.run(SistemaDeEmails.class, args); // Inicia a aplicação Spring Boot.
    }
}