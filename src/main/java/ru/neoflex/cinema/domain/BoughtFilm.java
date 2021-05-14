package ru.neoflex.cinema.domain;

import ru.neoflex.cinema.domain.composite.UserAndFilmCompositeId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bought_film")
public class BoughtFilm implements Serializable {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride( name = "userId", column = @Column(name = "user_id")),
            @AttributeOverride( name = "filmId", column = @Column(name = "film_id"))
    })
    private UserAndFilmCompositeId id;

    @Column(name = "film_quality")
    private int quality;
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
