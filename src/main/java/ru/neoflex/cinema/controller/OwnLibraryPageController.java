package ru.neoflex.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.cinema.domain.BoughtFilm;
import ru.neoflex.cinema.domain.RentedFilm;
import ru.neoflex.cinema.domain.User;
import ru.neoflex.cinema.repos.BoughtFilmRepo;
import ru.neoflex.cinema.repos.RentedFilmRepo;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("profile/own")
public class OwnLibraryPageController {
    @Autowired
    private BoughtFilmRepo boughtFilmRepo;
    @Autowired
    private RentedFilmRepo rentedFilmRepo;

    @GetMapping("/bought")
    public String viewBoughtPage(@AuthenticationPrincipal User user, Model model){
        List<BoughtFilm> boughtFilms = boughtFilmRepo.findAllById_UserId(user.getId());
        model.addAttribute("boughtFilms", boughtFilms);
        return "/bought";
    }

    @GetMapping("/rented")
    public String viewRentedPage(@AuthenticationPrincipal User user, Model model){
        rentedFilmRepo.deleteByEndDateBefore(LocalDateTime.now());
        List<RentedFilm> rentedFilms = rentedFilmRepo.findAllById_UserId(user.getId());
        model.addAttribute("rentedFilms", rentedFilms);
        return "/rented";
    }
}
