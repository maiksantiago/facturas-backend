package com.maiksantiago.facturas.backend.service;

import com.maiksantiago.facturas.backend.model.entity.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends CommonServiceImpl<Categoria, CrudRepository<Categoria, Long>>
        implements CategoriaService {

}