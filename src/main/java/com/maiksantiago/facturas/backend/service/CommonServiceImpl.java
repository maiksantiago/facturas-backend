package com.maiksantiago.facturas.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CommonServiceImpl<E, R extends CrudRepository<E, Long>> implements CommonService<E> {

    @Autowired
    protected R repository;

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        return (List<E>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public E findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}