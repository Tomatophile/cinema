package ru.neoflex.cinema.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Film implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "film_name")
    private String name;
    @Column(name = "film_year")
    private int year;
    @Column(name = "film_age_limit")
    private int ageLimit;
    @Column(name = "film_description")
    private String description;
    @Column(name = "film_rating")
    private float rating;
    @Column(name = "film_buy_price")
    private int buyPrice;
    @Column(name = "film_rent_price")
    private int rentPrice;
    @Column(name = "film_country")
    private String country;
    @Column(name = "film_img_ref")
    private String imgUrl;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "film_genre",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    public String getStringYear(){
        return String.valueOf(year);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String filmName) {
        this.name = filmName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int filmYear) {
        this.year = filmYear;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int filmAgeLimit) {
        this.ageLimit = filmAgeLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String filmDescription) {
        this.description = filmDescription;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float filmRating) {
        this.rating = filmRating;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int filmBuyPrice) {
        this.buyPrice = filmBuyPrice;
    }

    public int getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(int filmRentPrice) {
        this.rentPrice = filmRentPrice;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String filmCountry) {
        this.country = filmCountry;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> filmGenres) {
        this.genres = filmGenres;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> filmActors) {
        this.actors = filmActors;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
