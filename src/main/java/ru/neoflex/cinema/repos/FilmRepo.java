package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.neoflex.cinema.domain.Film;

import java.util.List;

public interface FilmRepo extends JpaRepository<Film, Integer> {
    List<Film> findAllByNameContains(String substring);

    @Query(value = "select * from film where id in(select film_id from film_genre where genre_id in(select id from genre where genre_name=?1))", nativeQuery = true)
    List<Film> findAllByGenre(String genre);

    List<Film> findAllByNameContainsAndGenres_Name(String substring, String genre);
}
