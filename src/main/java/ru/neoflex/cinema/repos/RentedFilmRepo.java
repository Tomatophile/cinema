package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.cinema.domain.RentedFilm;

import java.util.List;

public interface RentedFilmRepo extends JpaRepository<RentedFilm, Integer> {
    List<RentedFilm> findAllById_UserId(int id);
}
