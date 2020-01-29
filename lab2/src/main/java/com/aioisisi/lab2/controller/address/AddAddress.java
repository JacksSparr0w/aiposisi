package com.aioisisi.lab2.controller.address;

import com.aioisisi.lab2.entity.Address;
import com.aioisisi.lab2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/addresses/add")
public class AddAddress {
    private final AddressService addressService;

    @Autowired
    public AddAddress(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public String add(Model model){

        return null;
    }

    @PostMapping
    public String save(Address address){

        return null;
    }

}
