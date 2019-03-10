package ro.Final.project.ds.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "id_actor", unique = true)
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long idActor = 0;

    @Column(name = "name")
    private String name = "";


    @Column(name = "info")
    private String info = "";

    //@ManyToOne
    //@JoinColumn(name = "movie")
    //@NotNull
    // private Movie movie;

    //@Fetch(FetchMode.SELECT)
    //@LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    @ManyToMany(mappedBy = "actors", cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    //@JsonBackReference
    //@JsonIgnoreProperties("movies")
    private List<Movie> movies = new ArrayList<Movie>();


    public Actor(Long idActor, String name, String info, List<Movie> movies) {
        this.idActor = idActor;
        this.name = name;
        this.info = info;
        this.movies = movies;
    }

    public Actor(String name, String info, List<Movie> movies) {
        this.idActor = idActor;
        this.name = name;
        this.info = info;
        this.movies = movies;
    }

    public Actor(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public Actor(int idActor, String name, String info) {
        this.idActor = idActor;
        this.name = name;
        this.info = info;
    }

    //public Actor(String idActor, String name, String info ) {//BAD CONSTRUCTOR, ONLY FOR TESTE VALIDATOR
    //   this.idActor = idActor;
    //     this.name = name;
    //    this.info = info;
    // }
    public Actor() {
    }

    public long getId() {
        return idActor;
    }

    public void setId(long idActor) {
        this.idActor = idActor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

//    @JsonIgnore
//    public List<Movie> getMovies() {
//        return movies;
//    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Actor actor = (Actor) o;
//
//        if (idActor != actor.idActor) return false;
//        if (name != null ? !name.equals(actor.name) : actor.name != null) return false;
//        if (info != null ? !info.equals(actor.info) : actor.info != null) return false;
//        return movies != null ? movies.equals(actor.movies) : actor.movies == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = idActor;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (info != null ? info.hashCode() : 0);
//        result = 31 * result + (movies != null ? movies.hashCode() : 0);
//        return result;
//    }

    public String toString() {
        return ("|name|: " + name +
                "    |info|: " + "\t" + info +
//                "    |movie|: " + "\t" + Arrays.toString(movies.toArray()) +
                "    |id|: " + "\t" + idActor
                // + "    |accounts|: " + "\t" + Arrays.toString(accounts.toArray())

        );
    }
}
