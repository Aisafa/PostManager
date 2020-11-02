package ru.netology.manager.repozitory;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieInfo;

import ru.netology.repozitory.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PostManagerTestRepository {

    @Test
    public void shouldSave() {
        AfishaRepository repository = new AfishaRepository();
        MovieInfo Inception = new MovieInfo(1, "Inception", "Triller", 8, 120);
        repository.save(Inception);
        MovieInfo[] actual = repository.findAll();
        MovieInfo[] expected = new MovieInfo[]{Inception};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        AfishaRepository repository = new AfishaRepository();
        MovieInfo first = new MovieInfo(1, "Inception", "Triller", 10.0f, 130);
        MovieInfo second = new MovieInfo(2, "Macbeth", "Triller", 9.1f, 120);
        MovieInfo third = new MovieInfo(3, "The Gudge", "Triller", 8.3f, 132);
        MovieInfo fourth = new MovieInfo(4, "Awakenings", "Triller", 7.8f, 121);
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.findAll();
        MovieInfo[] actual = repository.findAll();
        MovieInfo[] expected = new MovieInfo[]{first, second, third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        AfishaRepository repository = new AfishaRepository();
        int idToFind = 3;
        MovieInfo second = new MovieInfo(2, "Macbeth", "Triller", 9.1f, 120);
        MovieInfo third = new MovieInfo(3, "The Gudge", "Triller", 8.3f, 132);
        MovieInfo fourth = new MovieInfo(4, "Awakenings", "Triller", 7.8f, 121);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        MovieInfo[] actual = new MovieInfo[]{repository.findById(idToFind)};
        MovieInfo[] expected = new MovieInfo[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        AfishaRepository repository = new AfishaRepository();
        int idToRemove = 2;
        MovieInfo second = new MovieInfo(2, "Macbeth", "Triller", 9.1f, 120);
        MovieInfo third = new MovieInfo(3, "The Gudge", "Triller", 8.3f, 132);
        MovieInfo fourth = new MovieInfo(4, "Awakenings", "Triller", 7.8f, 121);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.removeById(idToRemove);
        MovieInfo[] actual = repository.findAll();
        MovieInfo[] expected = new MovieInfo[]{third, fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        AfishaRepository repository = new AfishaRepository();
        MovieInfo second = new MovieInfo(2, "Macbeth", "Triller", 9.1f, 120);
        MovieInfo third = new MovieInfo(3, "The Gudge", "Triller", 8.3f, 132);
        MovieInfo fourth = new MovieInfo(4, "Awakenings", "Triller", 7.8f, 121);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.removeAll();
        MovieInfo[] actual = repository.findAll();
        MovieInfo[] expected = new MovieInfo[]{};
        assertArrayEquals(expected, actual);
    }
}
