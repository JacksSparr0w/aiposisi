package com.aioisisi.lab2.controller.user;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Log4j2
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
            log.log(Level.INFO, "find all routes for user");
            return "userRoutes";
        } else {
            log.log(Level.INFO, "no such user, sorry");
            return "redirect:/";
        }
    }

}
