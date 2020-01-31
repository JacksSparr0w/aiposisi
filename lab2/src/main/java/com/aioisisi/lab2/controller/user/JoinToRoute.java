package com.aioisisi.lab2.controller.user;

import com.aioisisi.lab2.entity.Message;
import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.User;
import com.aioisisi.lab2.service.RouteService;
import com.aioisisi.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/routes/{route_id}/join")
public class JoinToRoute {
    private final UserService userService;
    private final RouteService routeService;

    @Autowired
    public JoinToRoute(UserService userService, RouteService routeService) {
        this.userService = userService;
        this.routeService = routeService;
    }

    @GetMapping
    public String getPage(Model model, @PathVariable Integer route_id) {
        User user = new User();
        user.setRouteIdForJoin(route_id);
        model.addAttribute("route", route_id);
        model.addAttribute("user", user);
        return "writeLogin";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        Optional<User> userOptional = userService.findByLogin(user.getLogin());
        Optional<Route> routeOptional = routeService.findById(user.getRouteIdForJoin());
        if (userOptional.isPresent() && routeOptional.isPresent()) {
            Route route = routeOptional.get();
            user = userOptional.get();
            if (route.isNotJoined(user)) {
                route.addUser(user);
                routeService.save(route);
            } else {
                Message error = new Message("Вы уже записаны на этот маршрут!");
                model.addAttribute("message", error);
                return "error";
            }
        }
        return "redirect:/routes/all";
    }


}
