package com.SistemaDeEmails.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaDeEmails.Entidade.Noticia;
import com.SistemaDeEmails.service.NoticiaService;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {
    @Autowired
    private NoticiaService noticiaService;

    @PostMapping
    public Noticia cadastrarNoticia(@RequestBody Noticia noticia){
        return noticiaService.cadastrarNoticia(noticia);
    }

    @GetMapping
    public List<Noticia> listarNoticias() {
        return noticiaService.buscarNoticiasNaoProcessadas();
    }
}
