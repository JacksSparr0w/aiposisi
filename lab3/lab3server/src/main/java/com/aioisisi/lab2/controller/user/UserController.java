package com.aioisisi.lab2.controller.user;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.service.RouteService;
import com.aioisisi.lab2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    private final RouteService routeService;

    @Autowired
    public UserController(UserService userService, RouteService routeService) {
        this.userService = userService;
        this.routeService = routeService;
    }

    @GetMapping(value = "/{login}/watchRoutes")
    public List<Route> getRoutesForUser(@PathVariable String login) {
        Optional<User> userOptional = userService.findByLogin(login);
        if (userOptional.isPresent()) {
            List<Route> routes = userService.findRoutesByUser(userOptional.get());
            log.info("find all routes for user");
            return routes;
        } else {
            log.info("no such user, sorry");
            return null;
        }
    }

    @GetMapping(value = "/{login}")
    public Boolean existByLogin(@PathVariable String login) {
        return userService.existsByLogin(login);
    }

}
