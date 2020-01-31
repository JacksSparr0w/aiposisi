package com.aioisisi.lab2.controller.user;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/users/watchRoutes")
public class WatchRoutesForUser {
    private final UserService userService;

    @Autowired
    public WatchRoutesForUser(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String getRoutesForUser(Model model, User user) {
        Optional<User> userOptional = userService.findByLogin(user.getLogin());
        if (userOptional.isPresent()) {
            List<Route> routes = userService.findRoutesByUser(userOptional.get());
            model.addAttribute("routes", routes);
            return "userRoutes";
        } else {
            return "redirect:/";
        }
    }

}
