package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/routes/{id}/update")
public class UpdateRoute {
    private final RouteService routeService;

    @Autowired
    public UpdateRoute(RouteService routeService) {
        this.routeService = routeService;
    }


    @GetMapping
    public String add(Model model, @PathVariable Integer id){

        return null;
    }


    @PostMapping
    public String update(Route route){

        return null;
    }
}
