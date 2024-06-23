package com.SistemaDeEmails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.SistemaDeEmails.Entidade.Cliente;
import com.SistemaDeEmails.repositorio.ClienteRepository;

@Service
@Validated
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente){
        if (clienteRepository.existsByEmail(cliente.getEmail())) {  // Verificação se email ja existe.
            throw new IllegalArgumentException("Email já cadastrado");
        }
        return clienteRepository.save(cliente);     //Salva o cliente no repositorio com funções prontas exportada
    }

    public List<Cliente> buscarTodosClientes() {
        return clienteRepository.findAll(); // consulta todos clientes no banco de dados
    }
}
