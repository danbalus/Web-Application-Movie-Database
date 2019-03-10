package ro.Final.project.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.Final.project.ds.model.entity.Movie;
import ro.Final.project.ds.persistence.MovieRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService {


    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    @Override
    public void createMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        this.movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        this.movieRepository.delete(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return this.movieRepository.findById(id).get();
    }

    @Override
    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> listOfMovies=new ArrayList<>();
        this.movieRepository.findAll().forEach(listOfMovies::add);

        return listOfMovies;
    }

    @Override
    public Movie findMoviesByName(String name) {
        return this.movieRepository.findMoviesByName(name);
    }

    @Override
    public List<Movie> findMoviesByRating(int rating) {
        List<Movie> listOfMovies=new ArrayList<>();
        listOfMovies = this.movieRepository.findMoviesByRating(rating);
        return listOfMovies;
    }


//    @Override
//    public Movie rateMovie(String rate, Long userId) {
//        User User =
//        Movie movie = this.movieRepository.findById(userId).get();
//
//    }
}
