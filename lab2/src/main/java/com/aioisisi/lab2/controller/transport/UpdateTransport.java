package com.aioisisi.lab2.controller.transport;

import com.aioisisi.lab2.entity.Transport;
import com.aioisisi.lab2.entity.Type;
import com.aioisisi.lab2.service.TransportService;
import com.aioisisi.lab2.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/transports/{id}/update")
public class UpdateTransport {
    private static final Logger log = LoggerFactory.getLogger(UpdateTransport.class);
    private final TransportService transportService;
    private final TypeService typeService;

    @Autowired
    public UpdateTransport(TransportService transportService, TypeService typeService) {
        this.transportService = transportService;
        this.typeService = typeService;
    }


    @GetMapping
    public String add(Model model, @PathVariable Integer id){
        model.addAttribute("types", typeService.findAll());
        transportService.findById(id).ifPresent(x -> model.addAttribute("transport", x));
        return "addTransport";
    }


    @PostMapping
    public String update(Transport transport){
        Optional<Type> transportType = typeService.findById(transport.getType().getId());
        if (transportType.isPresent()){
            transport.setType(transportType.get());
            transportService.save(transport);
            log.info("update route with id =" + transport.getId());
            return "transport";
        } else {
            log.info("no such type, sorry");
            return "redirect:/transports/add";
        }
    }
}
