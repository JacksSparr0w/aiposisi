package com.aioisisi.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class Home {

    @GetMapping
    public String getHomePage(){
        return "home";
    }
}
