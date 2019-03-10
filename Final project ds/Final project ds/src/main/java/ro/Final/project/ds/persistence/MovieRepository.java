package ro.Final.project.ds.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.Final.project.ds.model.entity.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {
   // Movie getMovieByName(String name);
    Movie findMoviesByName(String name);
    List<Movie> findMoviesByRating(int rating);

}
