package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.service.AddressService;
import com.aioisisi.lab2.service.RouteService;
import com.aioisisi.lab2.service.TransportService;
import com.aioisisi.lab2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/routes")
public class RouteController {
    private static final Logger log = LoggerFactory.getLogger(RouteController.class);
    private final RouteService routeService;
    private final TransportService transportService;
    private final AddressService addressService;
    private final UserService userService;

    @Autowired
    public RouteController(RouteService routeService, TransportService transportService, AddressService addressService, UserService userService) {
        this.routeService = routeService;
        this.transportService = transportService;
        this.addressService = addressService;
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public List<Route> allRoutes() {
        log.info("all routes");
        return routeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Route getById(@PathVariable Integer id) {
        log.info("get route with id = " + id);
        return routeService.findById(id).get();
    }

    @Transactional
    @PostMapping(value = "/add")
    public Route addNewRoute(@RequestBody Route route) {
        route.setArrivalAddress(addressService.save(route.getArrivalAddress()));
        route.setDepartureAddress(addressService.save(route.getDepartureAddress()));
        routeService.save(route);

        log.info("add new route");
        return route;
    }

    @Transactional
    @DeleteMapping(value = "/{id}/delete")
    public void deleteRoute(@PathVariable("id") Route route) {
        log.info("delete route with id =" + route.getId());
        routeService.findById(route.getId()).ifPresent(routeService::delete);
    }

    @Transactional
    @PostMapping(value = "/{id}/update")
    public Route updateRoute(@PathVariable(value = "id") Integer id, @RequestBody Route route) {
        route.setArrivalAddress(addressService.save(route.getArrivalAddress()));
        route.setDepartureAddress(addressService.save(route.getDepartureAddress()));
        route.setUsers(routeService.findUsersByRoute(route.getId()));
        route.setId(id);
        routeService.save(route);

        log.info("update route with id =" + route.getId());
        return route;
    }

    @Transactional
    @PostMapping(value = "/{route_id}/join")
    public User addUserToRoute(@RequestBody User user, @PathVariable(value = "route_id") Route route) {
        User u = findUser(user);
        if (route.isNotJoined(u) && route.addUser(u)) {
            log.info("user with id = " + u.getId() + " joined the route with id = " + route.getId());
            routeService.save(route);
        } else {
            log.info("maybe there no free seats or you join this also");
        }
        return u;
    }

    private User findUser(User user) {
        Optional<User> userOptional = userService.findByEmail(normalizeLogin(user.getEmail()));
        return userOptional.orElseGet(() -> userService.save(user));
    }

    private String normalizeLogin(String login) {
        return login.toLowerCase().trim();
    }


}
