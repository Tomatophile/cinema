package ru.neoflex.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.neoflex.cinema.domain.BoughtFilm;
import ru.neoflex.cinema.domain.Film;
import ru.neoflex.cinema.domain.RentedFilm;
import ru.neoflex.cinema.domain.User;
import ru.neoflex.cinema.domain.composite.UserAndFilmCompositeId;
import ru.neoflex.cinema.repos.BoughtFilmRepo;
import ru.neoflex.cinema.repos.FilmRepo;
import ru.neoflex.cinema.repos.RentedFilmRepo;

import java.time.LocalDateTime;

@Controller
public class PaymentPageController {
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private BoughtFilmRepo boughtFilmRepo;
    @Autowired
    private RentedFilmRepo rentedFilmRepo;

    @GetMapping("/films/{id}/buy")
    public String viewBuyPage(@PathVariable int id, Model model){
        model.addAttribute("film", filmRepo.getOne(id));
        return "buyPage";
    }

    @PostMapping("/films/{id}/buy")
    public String buyFilm(
            @PathVariable int id,
            @AuthenticationPrincipal User user,
            @RequestParam int quality){
        BoughtFilm boughtFilm = new BoughtFilm();
        Film film = filmRepo.getOne(id);
        boughtFilm.setId(new UserAndFilmCompositeId(user.getId(), film.getId()));
        boughtFilm.setFilm(film);
        boughtFilm.setQuality(quality);
        boughtFilm.setUser(user);

        boughtFilmRepo.save(boughtFilm);

        return "redirect:/profile/own/bought";
    }

    @GetMapping("/films/{id}/rent")
    public String viewRentPage(@PathVariable int id, Model model){
        model.addAttribute("film", filmRepo.getOne(id));
        return "rentPage";
    }

    @PostMapping("/films/{id}/rent")
    public String rentFilm(
            @PathVariable int id,
            @AuthenticationPrincipal User user,
            @RequestParam int quality){
        RentedFilm rentedFilm = new RentedFilm();
        Film film = filmRepo.getOne(id);
        rentedFilm.setId(new UserAndFilmCompositeId(user.getId(), film.getId()));
        rentedFilm.setStartDate(LocalDateTime.now());
        rentedFilm.setEndDate(LocalDateTime.now().plusDays(7));
        rentedFilm.setFilm(film);
        rentedFilm.setQuality(quality);
        rentedFilm.setUser(user);

        rentedFilmRepo.save(rentedFilm);

        return "redirect:/profile/own/rented";
    }
}
