package com.aioisisi.lab2.controller.type;

import com.aioisisi.lab2.entity.Type;
import com.aioisisi.lab2.service.TypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/types")
public class TypeController {
    private static final Logger log = LoggerFactory.getLogger(TypeController.class);
    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping(value = "/all")
    public List<Type> allTypes(){
        log.info("all types");
        return typeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Type getTypeById(@PathVariable Integer id){
        log.info("get type by id = " + id);
        return typeService.findById(id).get();
    }

}
