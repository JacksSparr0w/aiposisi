package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.service.AddressService;
import com.aioisisi.lab2.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/routes/{id}/update")
public class UpdateRoute {
    private final RouteService routeService;
    private final AddressService addressService;

    @Autowired
    public UpdateRoute(RouteService routeService, AddressService addressService) {
        this.routeService = routeService;
        this.addressService = addressService;
    }


    @GetMapping
    public String updatePage(Model model, @PathVariable Integer id){
        Optional<Route> route = routeService.findById(id);
        if (route.isPresent()){
            model.addAttribute("route", route.get());
            return "addRoute";
        } else {
            return "redirect:/routes/all";
        }

    }


    @PostMapping
    public String update(Route route){
        route.setArrivalAddress(addressService.save(route.getArrivalAddress()));
        route.setDepartureAddress(addressService.save(route.getDepartureAddress()));
        routeService.save(route);

        return "redirect:/routes/all";
    }
}
