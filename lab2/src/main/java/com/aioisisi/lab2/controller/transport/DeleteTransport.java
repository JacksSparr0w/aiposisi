package com.aioisisi.lab2.controller.transport;

import com.aioisisi.lab2.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/transports/{id}/delete")
public class DeleteTransport {
    private final TransportService transportService;

    @Autowired
    public DeleteTransport(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping
    public String deleteTransport(@PathVariable Integer id) {
        transportService.findById(id).ifPresent(transportService::delete);

        return "redirect:/transports/all";
    }
}
