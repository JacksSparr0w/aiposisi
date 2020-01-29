package com.aioisisi.lab2.controller.address;

import com.aioisisi.lab2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/addresses/{id}/delete")
public class DeleteAddress {
    private final AddressService addressService;

    @Autowired
    public DeleteAddress(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public String deleteAddress(@PathVariable Integer id) {

        return null;
    }
}
