package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.Type;
import com.aioisisi.lab2.repository.TypeRepository;
import com.aioisisi.lab2.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    private TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type save(Type entity) {
        return null;
    }

    @Override
    public Optional<Type> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public List<Type> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
