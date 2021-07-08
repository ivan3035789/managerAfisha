package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManagerTest {

    private Film first = new Film(1, "first", "comedy");
    private Film second = new Film(2, "second", "comedy");
    private Film third = new Film(3, "third", "comedy");
    private Film fourth = new Film(4, "", "comedy");
    private Film fifth = new Film(5, "fifth", "comedy");
    private Film sixth = new Film(6, "sixth", "comedy");
    private Film seventh = new Film(7, "seventh ", "comedy");
    private Film eighth = new Film(8, "eighth", "comedy");
    private Film ninth = new Film(9, "ninth", "comedy");
    private Film tenth = new Film(10, "tenth", "comedy");
    private Film eleventh = new Film(11, "eleventh", "comedy");
    private Film twelfth = new Film(12, "twelfth", "comedy");

    @Test
    public void showTheLastFive4() {
    Film[] films = new Film[8];

    }

    @Test
    public void settingTheNumberOfRecentlySelectedMovies() {
        Manager manager = new Manager();

        manager.setRecentSelectedMovies(5);
        assertEquals(5, manager.getRecentSelectedMovies());
    }

    @Test
    public void settingTheValuesOfTheFields() {
        Film film = new Film();

        film.setId(1);
        film.setFilmName("First");
        film.setGenre("comedy");


        assertEquals(1, film.getId());
        assertEquals("First", film.getFilmName());
        assertEquals("comedy", film.getGenre());

    }

    @Test
    public void showTheLastFive() {
        Manager manager = new Manager(5);

        manager.addMovieFeed(first);
        manager.addMovieFeed(second);
        manager.addMovieFeed(third);
        manager.addMovieFeed(fourth);
        manager.addMovieFeed(fifth);
        manager.addMovieFeed(sixth);
        manager.addMovieFeed(seventh);
        manager.addMovieFeed(eighth);
        manager.addMovieFeed(ninth);
        manager.addMovieFeed(tenth);
        manager.addMovieFeed(eleventh);
        manager.addMovieFeed(twelfth);

        Film[] actual = manager.lastFilm(); //получ. последние фильмы
        Film[] expected = new Film[]{twelfth, eleventh, tenth, ninth, eighth};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void showTheLastTen() {
        Manager manager = new Manager(10);

        manager.addMovieFeed(first);
        manager.addMovieFeed(second);
        manager.addMovieFeed(third);
        manager.addMovieFeed(fourth);
        manager.addMovieFeed(fifth);
        manager.addMovieFeed(sixth);
        manager.addMovieFeed(seventh);
        manager.addMovieFeed(eighth);
        manager.addMovieFeed(ninth);
        manager.addMovieFeed(tenth);
        manager.addMovieFeed(eleventh);
        manager.addMovieFeed(twelfth);

        Film[] actual = manager.lastFilm();
        Film[] expected = new Film[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void IfThereAreLessThanTenFilmsThenYouGiveOutAsManyAsThereAre() {
        Manager manager = new Manager();

        manager.addMovieFeed(seventh);
        manager.addMovieFeed(eighth);
        manager.addMovieFeed(ninth);
        manager.addMovieFeed(tenth);
        manager.addMovieFeed(eleventh);
        manager.addMovieFeed(twelfth);
        Film[] actual = manager.lastFilm();
        Film[] expected = new Film[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void showTheLastZeroOrNegative() {
        Manager manager = new Manager(-5);

        manager.addMovieFeed(first);
        manager.addMovieFeed(second);
        manager.addMovieFeed(third);
        manager.addMovieFeed(fourth);
        manager.addMovieFeed(fifth);
        manager.addMovieFeed(sixth);
        manager.addMovieFeed(seventh);
        manager.addMovieFeed(eighth);
        manager.addMovieFeed(ninth);
        manager.addMovieFeed(tenth);
        manager.addMovieFeed(eleventh);
        manager.addMovieFeed(twelfth);
        Film[] actual = manager.lastFilm();
        Film[] expected = new Film[]{twelfth, eleventh, tenth, ninth, eighth,
                seventh, sixth, fifth, fourth, third};

        assertArrayEquals(expected, actual);
    }

}
