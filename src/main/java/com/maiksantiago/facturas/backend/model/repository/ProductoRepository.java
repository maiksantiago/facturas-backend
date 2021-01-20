package com.maiksantiago.facturas.backend.model.repository;

import com.maiksantiago.facturas.backend.model.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}