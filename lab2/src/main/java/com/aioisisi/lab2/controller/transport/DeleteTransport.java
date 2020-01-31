package com.aioisisi.lab2.controller.transport;

import com.aioisisi.lab2.service.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/transports/{id}/delete")
public class DeleteTransport {
    private static final Logger log = LoggerFactory.getLogger(DeleteTransport.class);

    private final TransportService transportService;

    @Autowired
    public DeleteTransport(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping
    public String deleteTransport(@PathVariable Integer id) {
        transportService.findById(id).ifPresent(transportService::delete);

        log.info("delete transport with id =" + id);
        return "redirect:/transports/all";
    }
}
