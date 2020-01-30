package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.repository.RouteRepository;
import com.aioisisi.lab2.repository.UserRepository;
import com.aioisisi.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RouteRepository routeRepository) {
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(User entity) {
        List<Route> routes = routeRepository.findAllByUsersContaining(entity);
        for (Route r: routes) {
            r.getUsers().remove(entity);
            routeRepository.save(r);
        }
        userRepository.delete(entity);
    }


}
