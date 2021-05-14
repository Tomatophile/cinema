package ru.neoflex.cinema.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.cinema.domain.User;

@Controller
@RequestMapping("/profile")
public class ProfilePageController {
    @GetMapping
    public String viewProfilePage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);
        return "/profile";
    }
}
