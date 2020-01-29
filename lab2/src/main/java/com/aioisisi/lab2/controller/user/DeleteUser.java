package com.aioisisi.lab2.controller.user;

import com.aioisisi.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/users/{id}/delete")
public class DeleteUser {
    private final UserService userService;

    @Autowired
    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String deleteUser(@PathVariable Integer id) {

        return null;
    }
}
