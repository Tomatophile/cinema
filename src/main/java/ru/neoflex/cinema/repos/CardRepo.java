package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.cinema.domain.Card;

import java.util.List;

public interface CardRepo extends JpaRepository<Card, Integer> {
    Card findByNumber(String number);
    List<Card> findAllByUser_Id(int id);
}
