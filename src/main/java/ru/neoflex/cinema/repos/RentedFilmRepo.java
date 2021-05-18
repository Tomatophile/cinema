package ru.neoflex.cinema.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.neoflex.cinema.domain.RentedFilm;

import java.time.LocalDateTime;
import java.util.List;

public interface RentedFilmRepo extends JpaRepository<RentedFilm, Integer> {
    List<RentedFilm> findAllById_UserId(int id);

    @Modifying
    @Transactional
    @Query(value = "delete from rented_film where end_date < :date", nativeQuery = true)
    int deleteByEndDateBefore(@Param("date")LocalDateTime date);
}
