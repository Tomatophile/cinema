package ru.neoflex.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.cinema.domain.BoughtFilm;
import ru.neoflex.cinema.domain.RentedFilm;
import ru.neoflex.cinema.domain.User;
import ru.neoflex.cinema.repos.BoughtFilmRepo;
import ru.neoflex.cinema.repos.FilmRepo;
import ru.neoflex.cinema.repos.RentedFilmRepo;

import java.util.List;

@Controller
@RequestMapping("/films/{id}")
public class FilmPageController {
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private BoughtFilmRepo boughtFilmRepo;
    @Autowired
    private RentedFilmRepo rentedFilmRepo;

    @GetMapping
    public String viewFilmPage(@AuthenticationPrincipal User user, @PathVariable int id, Model model){
        boolean bought = false;
        boolean rented = false;

        if(user!=null) {
            List<BoughtFilm> boughtFilms = boughtFilmRepo.findAllById_UserId(user.getId());
            List<RentedFilm> rentedFilms = rentedFilmRepo.findAllById_UserId(user.getId());

            for(BoughtFilm boughtFilm: boughtFilms){
                if (boughtFilm.getFilm().getId() == id) {
                    bought = true;
                    break;
                }
            }
            for(RentedFilm rentedFilm: rentedFilms){
                if (rentedFilm.getFilm().getId() == id) {
                    rented = true;
                    break;
                }
            }
        }

        model.addAttribute("film", filmRepo.getOne(id));
        model.addAttribute("bought", bought);
        model.addAttribute("rented", rented);
        return "/film";
    }
}
