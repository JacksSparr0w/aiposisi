package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/routes/all")
public class WatchAllRoutes {
    private final RouteService routeService;
    @Autowired
    public WatchAllRoutes(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String watchAllRoutes(Model model){

        return null;
    }
}