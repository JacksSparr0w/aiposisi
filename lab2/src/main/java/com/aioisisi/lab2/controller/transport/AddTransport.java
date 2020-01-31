package com.aioisisi.lab2.controller.transport;

import com.aioisisi.lab2.entity.Transport;
import com.aioisisi.lab2.entity.Type;
import com.aioisisi.lab2.service.TransportService;
import com.aioisisi.lab2.service.TypeService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Log4j2
@Controller
@RequestMapping(value = "/transports/add")
public class AddTransport {
    private final TransportService transportService;
    private final TypeService typeService;

    @Autowired
    public AddTransport(TransportService transportService, TypeService typeService) {
        this.transportService = transportService;
        this.typeService = typeService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("transport", new Transport());

        return "addTransport";
    }

    @PostMapping
    public String save(Transport transport){
        Optional<Type> transportType = typeService.findById(transport.getType().getId());
        if (transportType.isPresent()){
            transport.setType(transportType.get());
            transportService.save(transport);
            log.log(Level.INFO, "add new transport");
            return "redirect:/transports/all";
        } else {
            log.log(Level.INFO, "no such type, sorry");
            return "redirect:/transports/add";
        }
    }
}
