package com.km.Clientes.microserver.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.km.Clientes.microserver.entity.Clientes;
import com.km.Clientes.microserver.service.ClientesSevice;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	
	@Autowired
    private ClientesSevice clientesService;

    @PostMapping
    public ResponseEntity<Clientes> crearClientes(@RequestBody Clientes clientes) {
    	Clientes nuevoClientes = clientesService.crearClientes(clientes);
        return ResponseEntity.ok(nuevoClientes);
    }

    @GetMapping
    public ResponseEntity<List<Clientes>> obtenerTodosLosClientes() {
        List<Clientes> clientes = clientesService.obtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> obtenerClientesPorId(@PathVariable String id) {
        Optional<Clientes> clientes = clientesService.obtenerClientesPorId(id);
        return clientes.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> actualizarClientes(@PathVariable String id, @RequestBody Clientes clientes) {
    	clientes.setId(id);
        Clientes clientesActualizado = clientesService.actualizarClientes(clientes);
        return ResponseEntity.ok(clientesActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarClientes(@PathVariable String id) {
    	clientesService.eliminarClientesPorId(id);
        return ResponseEntity.noContent().build();
    }

}
