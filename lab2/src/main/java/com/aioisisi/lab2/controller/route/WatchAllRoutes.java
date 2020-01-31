package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/routes/all")
public class WatchAllRoutes {
    private static final Logger log = LoggerFactory.getLogger(WatchAllRoutes.class);
    private final RouteService routeService;
    @Autowired
    public WatchAllRoutes(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String watchAllRoutes(Model model){
        model.addAttribute("routes", routeService.findAll());

        log.info("all routes");
        return "routes";
    }
}