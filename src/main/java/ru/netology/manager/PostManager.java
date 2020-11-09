package ru.netology.manager;

import ru.netology.domain.MovieInfo;

public class PostManager {
    int countMovies = 10;

    public PostManager(int countMovies) {
        this.countMovies = countMovies;
    }

    public PostManager() {
    }

    private MovieInfo[] movies = new MovieInfo[0];

    public void addMovie(MovieInfo movie) {
        int length = movies.length + 1;
        MovieInfo[] tmp = new MovieInfo[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[length - 1] = movie;
        movies = tmp;
    }

    public MovieInfo[] getMovies() {
        int newSize = countMovies;
        MovieInfo[] result = new MovieInfo[newSize];
        int index = 0;
        for (int i = movies.length - 1; i >= 0 && index < countMovies; i--) {
            result[index] = movies[i];
            index++;
        }
        return result;
    }
}
