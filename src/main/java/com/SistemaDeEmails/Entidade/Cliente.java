package com.SistemaDeEmails.Entidade;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
public class Cliente {

    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento do id
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "E-mail é obrigatório")
    private String email;

    private LocalDate nascimento;

    //------------------------------------------------
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    //------------------------------------------------
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    //------------------------------------------------
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    //------------------------------------------------
    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    //------------------------------------------------
}
