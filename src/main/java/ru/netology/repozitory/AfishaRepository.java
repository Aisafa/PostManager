package ru.netology.repozitory;

import ru.netology.domain.MovieInfo;
import ru.netology.manager.PostManager;

import java.util.Arrays;

public class AfishaRepository {
    private MovieInfo[] movies = new MovieInfo[0];

    public void save(MovieInfo movie) {
        int length = movies.length + 1;
        MovieInfo[] tmp = new MovieInfo[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[length - 1] = movie;
        movies = tmp;
    }

    public MovieInfo[] findAll() {
        return movies;
    }

    public MovieInfo findById(int id) {

        for (MovieInfo movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = movies.length - 1;
        MovieInfo[] tmp = new MovieInfo[length];
        int index = 0;
        for (MovieInfo movie : movies) {
            if (movie.getId() != id) {
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        movies = new MovieInfo[0];
    }

}
