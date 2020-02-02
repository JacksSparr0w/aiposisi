package com.aioisisi.lab2.service;

import com.aioisisi.lab2.entity.Address;
import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.User;

import java.util.List;

public interface RouteService extends Service<Route> {
    List<User> findUsersByRoute(Integer route_id);
}
