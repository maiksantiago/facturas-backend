package com.maiksantiago.facturas.backend.model.repository;

import com.maiksantiago.facturas.backend.model.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}