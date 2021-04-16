package ru.neoflex.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.neoflex.cinema.repos.FilmRepo;

import java.util.stream.Collectors;

import static ru.neoflex.cinema.constants.FilmComparators.ratingComparator;

@Controller
public class HomePageController {
    @Autowired
    private FilmRepo filmRepo;

    @GetMapping
    public String viewHomePage(Model model){
        model.addAttribute("films", filmRepo.findAll().stream().sorted(ratingComparator).collect(Collectors.toList()));
        return "/home";
    }
}
