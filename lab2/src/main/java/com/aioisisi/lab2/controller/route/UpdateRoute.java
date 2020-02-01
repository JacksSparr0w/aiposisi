package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.service.AddressService;
import com.aioisisi.lab2.service.RouteService;
import com.aioisisi.lab2.service.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping(value = "/routes/{id}/update")
public class UpdateRoute {
    private static final Logger log = LoggerFactory.getLogger(UpdateRoute.class);
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
    public String update(Route route, @RequestParam(value = "departureDT") Date departureDT, @RequestParam(value = "arrivalDT") Date arrivalDT){
        route.setArrivalDateTime(arrivalDT);
        route.setDepartureDateTime(departureDT);
        route.setArrivalAddress(addressService.save(route.getArrivalAddress()));
        route.setDepartureAddress(addressService.save(route.getDepartureAddress()));
        route.setUsers(routeService.findUsersByRoute(route.getId()));
        routeService.save(route);

        log.info("update route with id =" + route.getId());
        return "redirect:/routes/all";
    }
}
