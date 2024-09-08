package com.km.Clientes.microserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.km.Clientes.microserver.entity.Clientes;


public interface ClientesRepository extends MongoRepository<Clientes, String>  {

}
