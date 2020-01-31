package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.service.AddressService;
import com.aioisisi.lab2.service.RouteService;
import com.aioisisi.lab2.service.TransportService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Log4j2
@Controller
@RequestMapping(value = "/routes/{id}/update")
public class UpdateRoute {
    private final RouteService routeService;
    private final AddressService addressService;
    private final TransportService transportService;

    @Autowired
    public UpdateRoute(RouteService routeService, AddressService addressService, TransportService transportService) {
        this.routeService = routeService;
        this.addressService = addressService;
        this.transportService = transportService;
    }


    @GetMapping
    public String updatePage(Model model, @PathVariable Integer id){
        Optional<Route> route = routeService.findById(id);
        if (route.isPresent()){
            model.addAttribute("transportList", transportService.findAll());
            model.addAttribute("route", route.get());
            model.addAttribute("users", route.get().getUsers());
            return "addRoute";
        } else {
            return "redirect:/routes/all";
        }

    }


    @PostMapping
    public String update(Route route){
        route.setArrivalAddress(addressService.save(route.getArrivalAddress()));
        route.setDepartureAddress(addressService.save(route.getDepartureAddress()));
        route.setUsers(routeService.findUsersByRoute(route.getId()));
        routeService.save(route);

        log.log(Level.INFO, "update route with id =" + route.getId());
        return "redirect:/routes/all";
    }
}
