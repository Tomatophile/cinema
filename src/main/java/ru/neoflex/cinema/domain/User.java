package ru.neoflex.cinema.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "client")
@Transactional
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String nickname;
    @Column(name = "password_hash")
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private char gender;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Card> cards;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<RentedFilm> rentedFilms;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<BoughtFilm> boughtFilms;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "client_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public boolean isAdmin(){
        for(Role role: roles){
            if(role.getAuthority().equals("ROLE_ADMIN")){
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getNickname();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Integer getAge(){
        return LocalDate.now().getYear()-birthday.getYear();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<RentedFilm> getRentedFilms() {
        return rentedFilms;
    }

    public void setRentedFilms(List<RentedFilm> rentedFilms) {
        this.rentedFilms = rentedFilms;
    }

    public List<BoughtFilm> getBoughtFilms() {
        return boughtFilms;
    }

    public void setBoughtFilms(List<BoughtFilm> boughtFilms) {
        this.boughtFilms = boughtFilms;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
