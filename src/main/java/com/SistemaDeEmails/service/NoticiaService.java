package com.SistemaDeEmails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDeEmails.Entidade.Noticia;
import com.SistemaDeEmails.repositorio.NoticiaRepository;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    public Noticia cadastrarNoticia(Noticia noticia){
        return noticiaRepository.save(noticia);
    }
    public List<Noticia> buscarNoticiasNaoProcessadas(){
        return noticiaRepository.findByProcessadaFalse();
    }
}
