package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.cinema.domain.Genre;

public interface GenreRepo extends JpaRepository<Genre, Integer> {
}
