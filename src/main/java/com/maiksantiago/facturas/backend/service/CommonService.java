package com.maiksantiago.facturas.backend.service;

import java.util.List;

public interface CommonService<E> {

    List<E> findAll();

    E findById(Long id);

    E save(E entity);

    void deleteById(Long id);

}