package com.maiksantiago.facturas.backend.service;

import com.maiksantiago.facturas.backend.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, CrudRepository<Cliente, Long>>
        implements ClienteService {

}