package com.aioisisi.lab2.controller.user;

import com.aioisisi.lab2.entity.Address;
import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.service.AddressService;
import com.aioisisi.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/users/{id}/update")
public class UpdateUser {
    private final UserService userService;

    @Autowired
    public UpdateUser(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String add(Model model, @PathVariable Integer id){

        return null;
    }


    @PostMapping
    public String update(User user){

        return null;
    }
}
