package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieInfo;
import ru.netology.repozitory.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private PostManager manager;
    private MovieInfo first = new MovieInfo(1, "Inception", "Triller", 10.0f, 130);
    MovieInfo second = new MovieInfo(2, "Macbeth", "Triller", 9.1f, 120);
    MovieInfo third = new MovieInfo(3, "The Gudge", "Triller", 8.3f, 132);
    MovieInfo fourth = new MovieInfo(4, "Awakenings", "Triller", 7.8f, 121);
    MovieInfo fifth = new MovieInfo(5, "Snowpiercer", "Triller", 7.1f, 126);
    MovieInfo sixth = new MovieInfo(6, "Interstellar", "Triller", 8, 169);
    MovieInfo seventh = new MovieInfo(7, "Forest Gump", "Triller", 10, 132);
    MovieInfo eight = new MovieInfo(8, "The Prestige", "Triller", 10, 125);
    MovieInfo ninth = new MovieInfo(9, "Invictus", "Triller", 7.6f, 134);
    MovieInfo tenth = new MovieInfo(10, "The terminal", "Triller", 8.3f, 124);

    @BeforeEach
    public void setUp() {
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eight);
        manager.addMovie(ninth);
        manager.addMovie(tenth);

    }

    @Test
    public void shouldAddedMovie() {
        PostManager manager = new PostManager();
        MovieInfo Inception = new MovieInfo(1, "Inception", "Triller", 8, 120);
        manager.addMovie(Inception);
        MovieInfo[] actual = manager.getMovie();
        MovieInfo[] expected = new MovieInfo[]{Inception};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMovie() {
        PostManager manager = new PostManager();
        MovieInfo first = new MovieInfo(1, "Inception", "Triller", 10.0f, 130);
        MovieInfo second = new MovieInfo(2, "Macbeth", "Triller", 9.1f, 120);
        MovieInfo third = new MovieInfo(3, "The Gudge", "Triller", 8.3f, 132);
        MovieInfo fourth = new MovieInfo(4, "Awakenings", "Triller", 7.8f, 121);
        MovieInfo fifth = new MovieInfo(5, "Snowpiercer", "Triller", 7.1f, 126);
        MovieInfo sixth = new MovieInfo(6, "Interstellar", "Triller", 8, 169);
        MovieInfo seventh = new MovieInfo(7, "Forest Gump", "Triller", 10, 132);
        MovieInfo eight = new MovieInfo(8, "The Prestige", "Triller", 10, 125);
        MovieInfo ninth = new MovieInfo(9, "Invictus", "Triller", 7.6f, 134);
        MovieInfo tenth = new MovieInfo(10, "The terminal", "Triller", 8.3f, 124);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eight);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        MovieInfo[] actual = manager.getMovie();
        MovieInfo[] expected = new MovieInfo[]{tenth, ninth, eight, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMovieOverTen() {
        PostManager manager = new PostManager();
        MovieInfo first = new MovieInfo(1, "Inception", "Triller", 10.0f, 130);
        MovieInfo second = new MovieInfo(2, "Macbeth", "Triller", 9.1f, 120);
        MovieInfo third = new MovieInfo(3, "The Gudge", "Triller", 8.3f, 132);
        MovieInfo fourth = new MovieInfo(4, "Awakenings", "Triller", 7.8f, 121);
        MovieInfo fifth = new MovieInfo(5, "Snowpiercer", "Triller", 7.1f, 126);
        MovieInfo sixth = new MovieInfo(6, "Interstellar", "Triller", 8, 169);
        MovieInfo seventh = new MovieInfo(7, "Forest Gump", "Triller", 10, 132);
        MovieInfo eight = new MovieInfo(8, "The Prestige", "Triller", 10, 125);
        MovieInfo ninth = new MovieInfo(9, "Invictus", "Triller", 7.6f, 134);
        MovieInfo tenth = new MovieInfo(10, "The terminal", "Triller", 8.3f, 124);
        MovieInfo eleventh = new MovieInfo(11, "Spider Man ", "Triller", 6.3f, 104);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eight);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        manager.addMovie(eleventh);
        MovieInfo[] actual = manager.getMovie();
        MovieInfo[] expected = new MovieInfo[]{eleventh, tenth, ninth, eight, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }
}

