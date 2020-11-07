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
    private MovieInfo second = new MovieInfo(2, "Macbeth", "Triller", 9.1f, 120);
    private MovieInfo third = new MovieInfo(3, "The Gudge", "Triller", 8.3f, 132);
    private MovieInfo fourth = new MovieInfo(4, "Awakenings", "Triller", 7.8f, 121);
    private MovieInfo fifth = new MovieInfo(5, "Snowpiercer", "Triller", 7.1f, 126);
    private MovieInfo sixth = new MovieInfo(6, "Interstellar", "Triller", 8, 169);
    private MovieInfo seventh = new MovieInfo(7, "Forest Gump", "Triller", 10, 132);
    private MovieInfo eight = new MovieInfo(8, "The Prestige", "Triller", 10, 125);
    private MovieInfo ninth = new MovieInfo(9, "Invictus", "Triller", 7.6f, 134);
    private MovieInfo tenth = new MovieInfo(10, "The terminal", "Triller", 8.3f, 124);
    private MovieInfo eleventh = new MovieInfo(10, "Titanic", "Triller", 8.3f, 124);

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
        manager.addMovie(eleventh);
    }

    @Test
    public void shouldAddedMovie() {
        int removeById = 1;
        MovieInfo[] returned = new MovieInfo[]{first};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(removeById);
        repository.removeById(removeById);
        manager.addMovie(second);
        MovieInfo[] actual = manager.getMovies();
        MovieInfo[] expected = new MovieInfo[]{first};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetMovies() {
        MovieInfo[] returned = new MovieInfo[]{first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth};
        doReturn(returned).when(repository).findAll();
        MovieInfo[] actual = manager.getMovies();
        MovieInfo[] expected = new MovieInfo[]{tenth, ninth, eight, seventh, sixth, fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoviesOverTen() {
        MovieInfo[] returned = new MovieInfo[]{first, second, third, fourth, fifth, sixth, seventh, eight, ninth, tenth, eleventh};
        doReturn(returned).when(repository).findAll();
        MovieInfo[] actual = manager.getMovies();
        MovieInfo[] expected = new MovieInfo[]{eleventh, tenth, ninth, eight, seventh, sixth, fifth, fourth, third, second};
        assertArrayEquals(expected, actual);
    }
}

