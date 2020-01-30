package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.service.AddressService;
import com.aioisisi.lab2.service.RouteService;
import com.aioisisi.lab2.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/routes/add")
public class AddRoute {
    private final RouteService routeService;
    private final TransportService transportService;
    private final AddressService addressService;

    @Autowired
    public AddRoute(RouteService routeService, TransportService transportService, AddressService addressService) {
        this.routeService = routeService;
        this.transportService = transportService;
        this.addressService = addressService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("transportList", transportService.findAll());
        model.addAttribute("route", new Route());
        return "addRoute";
    }

    @PostMapping
    public String save(Route route){
        route.setArrivalAddress(addressService.save(route.getArrivalAddress()));
        route.setDepartureAddress(addressService.save(route.getDepartureAddress()));
        routeService.save(route);

        return "redirect:/ ";
    }
}
