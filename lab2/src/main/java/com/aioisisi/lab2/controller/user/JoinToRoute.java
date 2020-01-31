package com.aioisisi.lab2.controller.user;

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
import org.springframework.web.servlet.ModelAndView;

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
        return "login";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        Optional<Route> routeOptional = routeService.findById(user.getRouteIdForJoin());
        if (routeOptional.isPresent()) {
            Route route = routeOptional.get();
            User u = findUser(user);
            if (route.isNotJoined(u) && route.addUser(u)) {
                routeService.save(route);
            } else {
                return "redirect:/";
            }
        }
        return "redirect:/routes/all";
    }

    private User findUser(User user){
        Optional<User> userOptional = userService.findByLogin(normalizeLogin(user.getLogin()));
        return userOptional.orElseGet(() -> userService.save(user));
    }

    private String normalizeLogin(String login){
        return login.toLowerCase().trim();
    }


}
