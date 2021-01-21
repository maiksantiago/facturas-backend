package com.maiksantiago.facturas.backend.model.repository;

import com.maiksantiago.facturas.backend.model.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<Factura, Long> {
}