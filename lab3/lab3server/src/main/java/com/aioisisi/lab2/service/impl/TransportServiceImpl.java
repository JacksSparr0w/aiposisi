package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.Transport;
import com.aioisisi.lab2.repository.RouteRepository;
import com.aioisisi.lab2.repository.TransportRepository;
import com.aioisisi.lab2.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportServiceImpl implements TransportService {
    private final TransportRepository transportRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public TransportServiceImpl(TransportRepository transportRepository, RouteRepository routeRepository){
        this.transportRepository = transportRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public Transport save(Transport entity) {
        return transportRepository.save(entity);
    }

    @Override
    public Optional<Transport> findById(Integer id) {
        return transportRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return transportRepository.existsById(id);
    }

    @Override
    public List<Transport> findAll() {
        return transportRepository.findAll();
    }

    @Override
    public void delete(Transport entity) {
        List<Route> routes = routeRepository.findAllByTransport(entity);
        if (routes != null) {
            routes.forEach(routeRepository::delete);
        }
        transportRepository.deleteById(entity.getId());
    }


}
