package ru.neoflex.cinema.domain;

import ru.neoflex.cinema.domain.composite.UserAndFilmCompositeId;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "rented_film")
public class RentedFilm implements Serializable {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride( name = "userId", column = @Column(name = "user_id")),
            @AttributeOverride( name = "filmId", column = @Column(name = "film_id"))
    })
    private UserAndFilmCompositeId id;

    @Column(name = "film_quality")
    private int quality;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    @ManyToOne(optional = false)
    @JoinColumn(name = "film_id", insertable = false, updatable = false)
    private Film film;

    public UserAndFilmCompositeId getId() {
        return id;
    }

    public void setId(UserAndFilmCompositeId id) {
        this.id = id;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
