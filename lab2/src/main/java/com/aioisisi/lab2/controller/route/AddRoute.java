package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.service.RouteService;
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

    @Autowired
    public AddRoute(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String add(Model model){

        return null;
    }

    @PostMapping
    public String save(Route route){

        return null;
    }
}
