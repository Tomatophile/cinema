package ru.neoflex.cinema.constants;

import ru.neoflex.cinema.domain.Film;

import java.util.Comparator;

public class FilmComparators {
    private FilmComparators() {
    }

    public static final Comparator<Film> defaultComparator = Comparator.comparingInt(Film::getId);
    public static final Comparator<Film> newComparator = (a, b) -> Integer.compare(b.getYear(), a.getYear());
    public static final Comparator<Film> ratingComparator = (a, b) -> Double.compare(b.getRating(), a.getRating());
    public static final Comparator<Film> abcComparator = Comparator.comparing(Film::getName, String.CASE_INSENSITIVE_ORDER);
}
