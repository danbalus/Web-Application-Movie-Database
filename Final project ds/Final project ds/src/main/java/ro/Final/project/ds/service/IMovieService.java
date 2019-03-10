package ro.Final.project.ds.service;

import ro.Final.project.ds.model.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public interface IMovieService {

    void createMovie(Movie movie);

    void updateMovie(Movie movie);

    void deleteMovie(Movie movie);

    Movie getMovieById(Long id);

    ArrayList<Movie> getAllMovies();

    Movie findMoviesByName(String name);
    //Movie rateMovie(String rate, Long userId);
    List<Movie> findMoviesByRating(int rating);

}
