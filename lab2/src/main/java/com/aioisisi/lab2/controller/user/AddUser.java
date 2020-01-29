package com.aioisisi.lab2.controller.user;

import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/users/add")
public class AddUser {
    private final UserService userService;

    @Autowired
    public AddUser(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String add(Model model){

        return null;
    }

    @PostMapping
    public String save(User user){

        return null;
    }
}
