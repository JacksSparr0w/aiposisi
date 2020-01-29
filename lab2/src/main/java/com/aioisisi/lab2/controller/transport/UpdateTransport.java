package com.aioisisi.lab2.controller.transport;

import com.aioisisi.lab2.entity.Transport;
import com.aioisisi.lab2.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/transports/{id}/update")
public class UpdateTransport {
    private final TransportService transportService;

    @Autowired
    public UpdateTransport(TransportService transportService) {
        this.transportService = transportService;
    }


    @GetMapping
    public String add(Model model, @PathVariable Integer id){

        return null;
    }


    @PostMapping
    public String update(Transport transport){

        return null;
    }
}
