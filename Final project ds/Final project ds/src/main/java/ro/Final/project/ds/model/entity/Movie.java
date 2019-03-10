package ro.Final.project.ds.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "movie",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id_movie")
        })

public class Movie {

    @Transient //ca sa ignore lista asta
    // private List<String> actorsStringList = new ArrayList<>();
    private ObservableList<String> actorsStringList = FXCollections.observableArrayList();

    public Movie(long idMovie, String name, String genre, String title, List<Actor> actors, List<Director> directors, int rating) {
        this.idMovie = idMovie;
        this.name = name;
        this.genre = genre;
        this.title = title;
        this.actors = actors;
        this.directors = directors;
        this.rating = rating;
    }

    public Movie(long idMovie, String name, String genre, String title, int rating) {
        this.idMovie = idMovie;
        this.name = name;
        this.genre = genre;
        this.title = title;
        this.rating = rating;
    }

    public Movie(String name, String genre, String title, int rating) {
        this.name = name;
        this.genre = genre;
        this.title = title;
        this.rating = rating;
    }

    public Movie(long idMovie, String name, String genre, String title, int rating, List<Actor> actors) {
        this.idMovie = idMovie;
        this.name = name;
        this.genre = genre;
        this.title = title;
        this.rating = rating;
        this.actors = actors;
    }

    public Movie(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public Movie() {
    }

    @Id
    @Column(name = "id_movie", unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long idMovie = 0l;

    @Column(name = "name")
    private String name = "";

    @Column(name = "genre")
    private String genre = "";

    @Column(name = "title")//INFORMATION
    private String title = "";

    @Column(name = "rating")
    private int rating = 0;


    //@Fetch(FetchMode.SELECT)
    //@LazyCollection(LazyCollectionOption.FALSE)
    //@JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    // @OrderBy("id_movie")

    @JoinTable(
            name = "filme_actori",
            joinColumns = {@JoinColumn(name = "id_movie")},
            inverseJoinColumns = {@JoinColumn(name = "id_actor")}
    )
    //@SortNatural
    //@JsonManagedReference
    //@JsonIgnoreProperties("actors")
    private List<Actor> actors;


    //@Fetch(FetchMode.SELECT)
    //@LazyCollection(LazyCollectionOption.FALSE)
    //@JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    //@OrderBy("id_movie")
    @JoinTable(
            name = "filme_director",
            joinColumns = {@JoinColumn(name = "id_movie")},
            inverseJoinColumns = {@JoinColumn(name = "id_director")}
    )
    //@SortNatural
    //@JsonManagedReference
    //@JsonIgnoreProperties("directors")
    private List<Director> directors;

    //@ManyToOne
    //@JoinColumn(name = "actor")
    //@NotNull
    //private Actor actors;

    //@Column(name = "actors")
    //private  String actors;

    // @GeneratedValue(generator = "incrementator")
    //@GenericGenerator(name = "incrementator", strategy = "increment")


    public long getId() {
        return idMovie;
    }

    public void setId(long idMovie) {
        this.idMovie = idMovie;
    }

    // genre, title, actors


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

//    public List<String> getActorsNameAsStringList() {
//        if (!actors.isEmpty()) {
//            System.out.println("actors are not empty");
//            for (Actor actor : actors) {
//                actorsStringList.add(actor.getName());
//            }
//        }
//
//        return actorsStringList;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (rating != movie.rating) return false;
        if (actorsStringList != null ? !actorsStringList.equals(movie.actorsStringList) : movie.actorsStringList != null)
            return false;
        if (idMovie != null ? !idMovie.equals(movie.idMovie) : movie.idMovie != null) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (genre != null ? !genre.equals(movie.genre) : movie.genre != null) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (actors != null ? !actors.equals(movie.actors) : movie.actors != null) return false;
        return directors != null ? directors.equals(movie.directors) : movie.directors == null;
    }

    public String toString() {
        return ("|name|: " + name +
                "    |genre|: " + "\t" + genre +
                "    |**actors**|: " + "\t" + Arrays.asList(actors) +
                "    |title|: " + "\t" + title +
                "    |rating|: " + "\t" + rating +
                "    |id|: " + "\t" + idMovie + "\n"
                // + "    |accounts|: " + "\t" + Arrays.toString(accounts.toArray())

        );
    }

    @Override
    public int hashCode() {
        int result = actorsStringList.hashCode();
        result = 31 * result + idMovie.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + genre.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + rating;
        result = 31 * result + actors.hashCode();
        result = 31 * result + directors.hashCode();
        return result;
    }
}
