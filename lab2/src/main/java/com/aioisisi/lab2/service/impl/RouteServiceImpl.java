package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.Transport;
import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.repository.RouteRepository;
import com.aioisisi.lab2.repository.TransportRepository;
import com.aioisisi.lab2.repository.UserRepository;
import com.aioisisi.lab2.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final TransportRepository transportRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository, UserRepository userRepository, TransportRepository transportRepository) {
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.transportRepository = transportRepository;
    }


    @Override
    public Route save(Route entity) {
        Transport tr = transportRepository.findById(entity.getTransport().getId()).get();
        entity.setTransport(tr);
        return routeRepository.save(entity);
    }

    @Override
    public Optional<Route> findById(Integer id) {
        return routeRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return routeRepository.existsById(id);
    }

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public void delete(Route entity) {
        routeRepository.delete(entity);
    }


    @Override
    public List<User> findUsersByRoute(Integer route_id) {
        List<Integer> users_id = routeRepository.findUsersByRoute(route_id);
        List<User> users = new ArrayList<>();
        for (Integer id : users_id){
            users.add(userRepository.findById(id).get());
        }
        return users;
        //todo stream or lambda
    }

}
