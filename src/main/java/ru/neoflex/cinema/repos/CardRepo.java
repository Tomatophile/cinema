package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.cinema.domain.Card;

public interface CardRepo extends JpaRepository<Card, Integer> {
}
