package com.aioisisi.lab2.controller.transport;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.Transport;
import com.aioisisi.lab2.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/transports/add")
public class AddTransport {
    private final TransportService transportService;

    @Autowired
    public AddTransport(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("types", transportService.findAll());
        model.addAttribute("route", new Route());
    }

    @PostMapping
    public String save(Transport transport){

        return null;
    }
}
