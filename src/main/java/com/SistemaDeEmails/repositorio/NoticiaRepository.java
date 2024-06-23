package com.SistemaDeEmails.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDeEmails.Entidade.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long> {
    List<Noticia> findByProcessadaFalse();
}
