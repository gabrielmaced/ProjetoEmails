package com.SistemaDeEmails.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDeEmails.Entidade.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Classe extendida do Jpa com métodos CRUD prontos
    boolean existsByEmail(String email);
}