package ru.neoflex.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.neoflex.cinema.domain.Film;
import ru.neoflex.cinema.repos.FilmRepo;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import static ru.neoflex.cinema.constants.FilmComparators.*;

@Controller
@RequestMapping("/films")
public class LibraryPageController {
    @Autowired
    private FilmRepo filmRepo;

    @GetMapping
    public String viewLibraryPage(
            @RequestParam(required = false) String selectedGenre,
            @RequestParam(required = false) String contains,
            @RequestParam(required = false) String sort,
            Model model) {
        Comparator<Film> comparator = sortFilms(sort);
        List<Film> films = filterFilms(contains, selectedGenre);
        films.sort(sortFilms(sort));

        model.addAttribute("genres", filmRepo.findDistinctGenre());
        model.addAttribute("selectedGenre", selectedGenre);
        model.addAttribute("contains", contains);
        model.addAttribute("sort", sort);
        model.addAttribute("films", films);
        return "/library";
    }

    private Comparator<Film> sortFilms(String sort) {
        if (sort != null && !sort.isEmpty()) {
            switch (sort) {
                case "new":
                    return newComparator;
                case "rating":
                    return ratingComparator;
                case "abc":
                    return abcComparator;
                default:
                    return defaultComparator;
            }
        }
        return defaultComparator;
    }

    private List<Film> filterFilms(String contains, String selectedGenre) {
        if (contains != null && !contains.isEmpty() && !contains.matches("[ ]*") && selectedGenre != null && !selectedGenre.isEmpty() && !selectedGenre.equals("--")) {
            return filmRepo.findAllByNameContainsAndGenre(contains, selectedGenre);
        } else if (contains != null && !contains.isEmpty() && !contains.matches("[ ]*")) {
            return filmRepo.findAllByNameContains(contains);
        } else if (selectedGenre != null && !selectedGenre.isEmpty() && !selectedGenre.equals("--")){
            return filmRepo.findAllByGenre(selectedGenre);
        }
            return filmRepo.findAll();
    }
}

