package com.maiksantiago.facturas.backend.service;

import com.maiksantiago.facturas.backend.model.entity.Factura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends CommonServiceImpl<Factura, CrudRepository<Factura, Long>>
        implements FacturaService {

}