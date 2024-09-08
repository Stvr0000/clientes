package com.km.Clientes.microserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.km.Clientes.microserver.entity.Clientes;
import com.km.Clientes.microserver.repository.ClientesRepository;

@Service
public class ClientesSevice {

    @Autowired
    private ClientesRepository clientesRepository;

    public Clientes crearClientes(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    public List<Clientes> obtenerTodosLosClientes() {
        return clientesRepository.findAll();
    }

    public Optional<Clientes> obtenerClientesPorId(String id) {
        return clientesRepository.findById(id);
    }

    public Clientes actualizarClientes(Clientes clientes) {
        if (clientesRepository.existsById(clientes.getId())) {
            return clientesRepository.save(clientes);
        }
        return null; // O maneja esto de otra manera si el cliente no existe
    }

    public void eliminarClientesPorId(String id) {
        clientesRepository.deleteById(id);
    }
}
