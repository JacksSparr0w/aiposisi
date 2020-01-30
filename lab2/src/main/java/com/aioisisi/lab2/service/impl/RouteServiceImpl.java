package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.repository.RouteRepository;
import com.aioisisi.lab2.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }


    @Override
    public Route save(Route entity) {
        return null;
    }

    @Override
    public Optional<Route> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public List<Route> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
