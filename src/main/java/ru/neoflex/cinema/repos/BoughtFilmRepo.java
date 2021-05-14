package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.cinema.domain.BoughtFilm;

import java.util.List;

public interface BoughtFilmRepo extends JpaRepository<BoughtFilm, Integer> {
    List<BoughtFilm> findAllById_UserId(int id);
}
