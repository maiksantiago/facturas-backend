package com.maiksantiago.facturas.backend.service;

import com.maiksantiago.facturas.backend.model.entity.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends CommonServiceImpl<Producto, CrudRepository<Producto, Long>>
        implements ProductoService {

}