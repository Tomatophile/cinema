package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.neoflex.cinema.domain.Film;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film, Integer> {
    List<Film> findAllByNameContains(String substring);

    List<Film> findAllByGenre(String genre);

    List<Film> findAllByNameContainsAndGenre(String substring, String genre);

    @Query(value = "SELECT DISTINCT genre FROM film", nativeQuery = true)
    List<String> findDistinctGenre();
}
