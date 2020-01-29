package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.repository.UserRepository;
import com.aioisisi.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
