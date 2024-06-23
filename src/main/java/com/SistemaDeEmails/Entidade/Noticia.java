package com.SistemaDeEmails.Entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Noticia {
    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento do id
    private Long id;
    
    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Descrição é obrigatório")
    private String descricao;

    private String link;
    private boolean processada;


    //------------------------------------------------
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    //------------------------------------------------
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    //------------------------------------------------
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    //------------------------------------------------
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    //------------------------------------------------
    public boolean getProcessada() {
        return processada;
    }
    public void setProcessada(boolean processada) {
        this.processada = processada;
    }
    //------------------------------------------------
    
}
