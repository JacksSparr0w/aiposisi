package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.Transport;
import com.aioisisi.lab2.repository.TransportRepository;
import com.aioisisi.lab2.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportServiceImpl implements TransportService {
    private TransportRepository transportRepository;

    @Autowired
    public TransportServiceImpl(TransportRepository transportRepository){
        this.transportRepository = transportRepository;
    }

    @Override
    public Transport save(Transport entity) {
        return null;
    }

    @Override
    public Optional<Transport> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public List<Transport> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
