package com.aioisisi.lab2.service;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    T save(T entity);

    Optional<T> findById(Integer id);

    boolean existsById(Integer id);

    List<T> findAll();

    void deleteById(Integer id);

}