package ru.neoflex.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.cinema.domain.User;
import ru.neoflex.cinema.repos.RoleRepo;
import ru.neoflex.cinema.repos.UserRepo;

import java.util.Collections;


@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    RoleRepo roleRepo;

    @GetMapping
    public String viewRegistrationPage(){
        return "/registration";
    }

    @PostMapping
    public String addNewUser(User user, Model model) {
        User userFromDB = userRepo.findByNickname(user.getNickname());
        if(userFromDB!=null){
            model.addAttribute("message", "Это имя пользователя уже занято!");
            return "/registration";
        }
        userFromDB = userRepo.findByEmail(user.getEmail());
        if(userFromDB!=null){
            model.addAttribute("message", "Этот адрес электронной почты уже занят!");
            return "/registration";
        }

        user.setRoles(Collections.singleton(roleRepo.findByName("ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepo.save(user);

        return "redirect:/login";
    }

}
