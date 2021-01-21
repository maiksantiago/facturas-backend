package com.maiksantiago.facturas.backend.model.repository;

import com.maiksantiago.facturas.backend.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}