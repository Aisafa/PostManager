package ru.netology.manager;

import ru.netology.domain.MovieInfo;
import ru.netology.repozitory.AfishaRepository;

public class PostManager {
    private AfishaRepository repository;


    private MovieInfo[] movies = new MovieInfo[0];

    public void addMovie(MovieInfo movie) {
//        repository.save(movie);
        int length = movies.length + 1;
        MovieInfo[] tmp = new MovieInfo[length];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[length - 1] = movie;
        movies = tmp;
    }

    public MovieInfo[] getMovie() {
        int countMovies = 10;
        int newSize = countMovies;
        if (newSize > movies.length)
            newSize = movies.length;
        MovieInfo[] result = new MovieInfo[newSize];
        int index = 0;
        for (int i = movies.length - 1; i >= 0 && index < countMovies; i--) {
            result[index] = movies[i];
            index++;
        }
        return result;
    }

//    public void removeById(int id){
//        repository.removeById(id);
//    }
}
