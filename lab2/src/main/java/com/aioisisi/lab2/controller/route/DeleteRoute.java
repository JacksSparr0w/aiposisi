package com.aioisisi.lab2.controller.route;

import com.aioisisi.lab2.service.RouteService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping(value = "/routes/{id}/delete")
public class DeleteRoute {
    private final RouteService routeService;

    @Autowired
    public DeleteRoute(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public String deleteRoute(@PathVariable Integer id) {
        routeService.findById(id).ifPresent(routeService::delete);

        log.log(Level.INFO, "delete route with id =" + id);
        return "redirect:/routes/all";
    }
}
