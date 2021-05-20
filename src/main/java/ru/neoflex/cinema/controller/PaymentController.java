package ru.neoflex.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.neoflex.cinema.domain.*;
import ru.neoflex.cinema.domain.composite.UserAndFilmCompositeId;
import ru.neoflex.cinema.repos.*;

import java.time.LocalDateTime;

@Controller
public class PaymentController {
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private BoughtFilmRepo boughtFilmRepo;
    @Autowired
    private RentedFilmRepo rentedFilmRepo;
    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private VoucherRepo voucherRepo;

    @GetMapping("/films/{id}/buy")
    public String viewBuyPage(@PathVariable int id, Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("cards", cardRepo.findAllByUser_Id(user.getId()));
        model.addAttribute("film", filmRepo.getOne(id));
        return "buyPage";
    }

    @PostMapping("/films/{id}/buy")
    public String buyFilm(
            @PathVariable int id,
            @AuthenticationPrincipal User user,
            @RequestParam int quality,
            @RequestParam String card) {
        BoughtFilm boughtFilm = new BoughtFilm();
        Film film = filmRepo.getOne(id);
        boughtFilm.setId(new UserAndFilmCompositeId(user.getId(), film.getId()));
        boughtFilm.setFilm(film);
        boughtFilm.setQuality(quality);
        boughtFilm.setUser(user);

        newVoucher(card, film, "buy");

        boughtFilmRepo.save(boughtFilm);

        return "redirect:/profile/own/bought";
    }

    @GetMapping("/films/{id}/rent")
    public String viewRentPage(@PathVariable int id, Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("cards", cardRepo.findAllByUser_Id(user.getId()));
        model.addAttribute("film", filmRepo.getOne(id));
        return "rentPage";
    }

    @PostMapping("/films/{id}/rent")
    public String rentFilm(
            @PathVariable int id,
            @AuthenticationPrincipal User user,
            @RequestParam int quality,
            @RequestParam String card) {
        RentedFilm rentedFilm = new RentedFilm();
        Film film = filmRepo.getOne(id);
        rentedFilm.setId(new UserAndFilmCompositeId(user.getId(), film.getId()));
        rentedFilm.setStartDate(LocalDateTime.now());
        rentedFilm.setEndDate(LocalDateTime.now().plusDays(7));
        rentedFilm.setFilm(film);
        rentedFilm.setQuality(quality);
        rentedFilm.setUser(user);

        newVoucher(card, film, "rent");

        rentedFilmRepo.save(rentedFilm);

        return "redirect:/profile/own/rented";
    }

    @GetMapping("/profile/card/new")
    public String newCardForm() {
        return "newCard";
    }

    @PostMapping("/profile/card/new")
    public String newCardAdd(Card card, @AuthenticationPrincipal User user) {
        Card cardFromDB = cardRepo.findByNumber(card.getNumber());
        if (cardFromDB == null) {
            card.setUser(user);
        }

        cardRepo.save(card);

        return "redirect:/profile";
    }

    private void newVoucher(String card, Film film, String type) {
        Voucher voucher = new Voucher();
        voucher.setFilm(film);
        voucher.setPaymentType(type);
        voucher.setCard(cardRepo.findByNumber(card));

        voucherRepo.save(voucher);
    }
}
