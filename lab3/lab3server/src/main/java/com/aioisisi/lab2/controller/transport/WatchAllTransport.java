package com.aioisisi.lab2.controller.transport;

import com.aioisisi.lab2.service.TransportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/transports/all")
public class WatchAllTransport {
    private static final Logger log = LoggerFactory.getLogger(WatchAllTransport.class);
    private final TransportService transportService;
    @Autowired
    public WatchAllTransport(TransportService transportService) {
        this.transportService = transportService;
    }

    @GetMapping
    public String watchAllTransport(Model model){
        model.addAttribute("transportList", transportService.findAll());

        log.info("all transports");
        return "transport";
    }
}
