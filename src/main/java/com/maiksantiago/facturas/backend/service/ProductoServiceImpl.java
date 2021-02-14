package com.maiksantiago.facturas.backend.service;

import com.maiksantiago.facturas.backend.model.entity.Producto;
import com.maiksantiago.facturas.backend.model.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl extends CommonServiceImpl<Producto, ProductoRepository>
        implements ProductoService {

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

}