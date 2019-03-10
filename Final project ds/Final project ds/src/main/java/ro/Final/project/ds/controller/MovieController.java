package ro.Final.project.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.Final.project.ds.model.entity.Movie;
import ro.Final.project.ds.model.entity.User;
import ro.Final.project.ds.model.features.MailService;
import ro.Final.project.ds.service.IMovieService;
import ro.Final.project.ds.service.IUserService;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class MovieController {
    private IMovieService movieService;
    private IUserService userService;

    @Autowired
    public MovieController(IMovieService movieService, IUserService userService){
        this.movieService = movieService;
        this.userService = userService;
    }


    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){

        movieService.createMovie(movie);
        this.sendMailToAll(movie);

        return ResponseEntity.ok(movie);
    }

    @PutMapping("/movies")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){

        movieService.updateMovie(movie);

        return ResponseEntity.ok(movie);
    }

//    @DeleteMapping("/movies")
//    public ResponseEntity<Movie> deleteMovie(@RequestBody Movie movie){
//
//        movieService.deleteMovie(movie);
//
//        return ResponseEntity.ok(movie);
//    }
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable(value ="id") Long id){

        Movie movie = movieService.getMovieById(id);
        movieService.deleteMovie(movie);

        return ResponseEntity.ok(movie);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(value ="id") Long id){

        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){

        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PutMapping("/movies/user/{userId}/movieName/{movieName}/rating/{rating}")
    public ResponseEntity<User> rateMovie(@PathVariable(value = "rating") String rating,
                                            @PathVariable(value = "userId") Long userId,
                                            @PathVariable(value = "movieName") String movieName){

        User user = userService.getUserById(userId);
        //long idMovie = movieService.findMoviesByName(movieName).getId();
        String nameMovie = movieService.findMoviesByName(movieName).getName();
//        if(user == null){
////            throw new NullPointerException("Problema in demersul aplicatiei/ User deconectat");
////        }
        //Map<Long, Integer> ratings = user.getRatings();
        Map<String, Integer> ratings = user.getRatings();
        ratings.put(nameMovie, Integer.parseInt(rating));
        user.setRatings(ratings);

        userService.updateUser(user);

        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/movies/sendMail/{mail}")
    public ResponseEntity<String> sendMail(@PathVariable(value ="mail") String mail){
        //System.out.println("Sending mail "+ message);
        //String messageToEmail = "";
        //File file = new File("../a3_2/consumer/intro.txt");
        //Scanner sc = new Scanner(file);
        //String email = sc.nextLine();
        //System.out.println("email email "+ email);
        //String password = sc.nextLine();
        MailService mailService = new MailService("robydanutzu@gmail.com", "robydanutzu2018!");
        mailService.sendMail(mail,"Info news Mail ", "It s a new film in town! Check it out!!");

        return ResponseEntity.ok("DONE");
    }

    public void sendMailToAll(Movie movie){
        MailService mailService = new MailService("robydanutzu@gmail.com", "robydanutzu2018!");
        String mail;
        List<User> userList = userService.getAllUsers();
        for (User element:userList
             ) {
            mail = element.getEmail();
            mailService.sendMail(mail,"News ", "It s a new film in town "
                    + movie.getName() +"! Check it out!!");

        }
    }
    @GetMapping("/movies/search/rating/{rating}")
    public ResponseEntity<List<Movie>> getMoviesByRating(@PathVariable(value ="rating") int rating){

        return ResponseEntity.ok(movieService.findMoviesByRating(rating));
    }
}
