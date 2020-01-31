package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/routes/{id}/delete")
public class DeleteRoute {
    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteRoute.class);
    private final RouteService routeService;

    @Autowired
    public DeleteRoute(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String deleteRoute(@PathVariable Integer id) {
        routeService.findById(id).ifPresent(routeService::delete);

        LOGGER.info("delete route with id =" + id);
        return "redirect:/routes/all";
    }
}
