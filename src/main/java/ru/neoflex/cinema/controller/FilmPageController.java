package ru.neoflex.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.cinema.repos.FilmRepo;

@Controller
@RequestMapping("/films/{id}")
public class FilmPageController {
    @Autowired
    private FilmRepo filmRepo;

    @GetMapping
    public String viewFilmPage(@PathVariable int id, Model model){
        model.addAttribute("film", filmRepo.findById(id).get());
        return "/film";
    }
}
