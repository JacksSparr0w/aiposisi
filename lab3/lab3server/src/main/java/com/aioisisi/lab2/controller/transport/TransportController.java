package com.aioisisi.lab2.controller.transport;

import com.aioisisi.lab2.entity.Transport;
import com.aioisisi.lab2.entity.Type;
import com.aioisisi.lab2.service.TransportService;
import com.aioisisi.lab2.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/transports")
public class TransportController {
    private static final Logger log = LoggerFactory.getLogger(TransportController.class);
    private final TransportService transportService;
    private final TypeService typeService;

    @Autowired
    public TransportController(TransportService transportService, TypeService typeService) {
        this.transportService = transportService;
        this.typeService = typeService;
    }

    @Transactional
    @PostMapping(value = "/add")
    public Transport addNewTransport(@RequestBody Transport transport) {
        Optional<Type> transportType = typeService.findById(transport.getType().getId());
        if (transportType.isPresent()) {
            transport.setType(transportType.get());
            transportService.save(transport);
            log.info("add new transport");
            return transport;
        } else {
            log.info("no such type, sorry");
            return null;
        }
    }

    @GetMapping(value = "/all")
    public List<Transport> allTransports(){
        log.info("all transports");
        return transportService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Transport getTransportById(@PathVariable Integer id){
        return transportService.findById(id).get();
    }

    @Transactional
    @DeleteMapping(value = "/{id}/delete")
    public List<Transport> deleteTransport(@PathVariable(value = "id") Transport transport) {
        log.info("delete transport with id =" + transport.getId());
        transportService.findById(transport.getId()).ifPresent(transportService::delete);
        return transportService.findAll();
    }

    @Transactional
    @PostMapping(value = "/{id}/update")
    public Transport updateTransport(@PathVariable(value = "id") Integer id, @RequestBody Transport transport) {
        Optional<Type> transportType = typeService.findById(transport.getType().getId());
        if (transportType.isPresent()){
            transport.setType(transportType.get());
            transport.setId(id);
            transportService.save(transport);
            log.info("update route with id =" + transport.getId());
            return transport;
        } else {
            log.info("no such type, sorry");
            return null;
        }
    }

}
