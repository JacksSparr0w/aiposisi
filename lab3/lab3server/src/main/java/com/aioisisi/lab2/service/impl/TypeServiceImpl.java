package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.Transport;
import com.aioisisi.lab2.entity.Type;
import com.aioisisi.lab2.repository.RouteRepository;
import com.aioisisi.lab2.repository.TransportRepository;
import com.aioisisi.lab2.repository.TypeRepository;
import com.aioisisi.lab2.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    private final TransportRepository transportRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository, TransportRepository transportRepository, RouteRepository routeRepository) {
        this.typeRepository = typeRepository;
        this.transportRepository = transportRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public Type save(Type entity) {
        return typeRepository.save(entity);
    }

    @Override
    public Optional<Type> findById(Integer id) {
        return typeRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return typeRepository.existsById(id);
    }

    @Override
    public List<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public void delete(Type entity) {
        List<Transport> transports = transportRepository.findAllByType(entity);
        if (transports != null) {
            for (Transport t : transports) {
                List<Route> routes = routeRepository.findAllByTransport(t);
                if (routes != null) {
                    routes.forEach(routeRepository::delete);
                }
                ;
                transportRepository.delete(t);
            }
        }
        typeRepository.delete(entity);
    }
}
