package com.maiksantiago.facturas.backend.service;

import com.maiksantiago.facturas.backend.model.entity.Producto;

import java.util.List;

public interface ProductoService extends CommonService<Producto> {

    List<Producto> findByNombre(String nombre);

}