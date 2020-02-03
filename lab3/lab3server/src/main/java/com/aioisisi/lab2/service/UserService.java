package com.aioisisi.lab2.service;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service<User> {
    List<Route> findRoutesByUser(User user);

    Optional<User> findByLogin(String login);

    Boolean existsByLogin(String login);
}
