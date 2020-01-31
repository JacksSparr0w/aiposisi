package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.service.RouteService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
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
        model.addAttribute("routes", routeService.findAll());

        log.log(Level.INFO, "all routes");
        return "routes";
    }
}