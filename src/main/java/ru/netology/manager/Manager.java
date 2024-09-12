package ru.netology.manager;

import ru.netology.domain.Film;

public class Manager {
    private Film[] film = new Film[0];
    private int recentSelectedMovies = 10;

    public Film[] getFilm() {
        return film;
    }

    public void setFilm(Film[] film) {
        this.film = film;
    }

    public int getRecentSelectedMovies() {
        return recentSelectedMovies;
    }

    public void setRecentSelectedMovies(int recentSelectedMovies) {
        this.recentSelectedMovies = recentSelectedMovies;
    }

    public Manager() {
    }

    public Manager(int recentSelectedMovies) {
        if (recentSelectedMovies >= 0) {
            this.recentSelectedMovies = recentSelectedMovies;
        }
    }

    public void addMovieFeed(Film item) {
        int length = film.length + 1;
        Film[] tmp = new Film[length];
        System.arraycopy(film, 0, tmp, 0, film.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        film = tmp;
    }

    public Film[] lastFilm() {
        int selectedFilms = film.length;   //количество фильмов в ленте

        if (recentSelectedMovies <= film.length) {
            selectedFilms = recentSelectedMovies;
        } else {
            selectedFilms = film.length;
        }

        Film[] result = new Film[selectedFilms];
        for (int i = 0; i < result.length; i++) {
            int index = film.length - i - 1;
            result[i] = film[index];
        }
        return result;
    }
}