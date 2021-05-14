package ru.neoflex.cinema.domain.composite;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserAndFilmCompositeId implements Serializable{
    private int userId;
    private int filmId;

    public UserAndFilmCompositeId() {
    }

    public UserAndFilmCompositeId(int userId, int filmId) {
        this.userId = userId;
        this.filmId = filmId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
}
