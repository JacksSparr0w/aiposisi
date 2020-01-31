package com.aioisisi.lab2.controller.transport;

import com.aioisisi.lab2.service.RouteService;
import com.aioisisi.lab2.service.TransportService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping(value = "/transports/all")
public class WatchAllTransport {
    private final TransportService transportService;
    @Autowired
    public WatchAllTransport(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping
    public String watchAllTransport(Model model){
        model.addAttribute("transportList", transportService.findAll());

        log.log(Level.INFO, "all transports");
        return "transport";
    }
}
