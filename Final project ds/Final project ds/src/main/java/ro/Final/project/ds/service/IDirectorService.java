package ro.Final.project.ds.service;

import ro.Final.project.ds.model.entity.Director;

import java.util.ArrayList;

public interface IDirectorService {

    void createDirector(Director director);

    void updateDirector(Director director);

    void deleteDirector(Director director);

    Director getDirectorById(Long id);

    ArrayList<Director> getAllDirectors();
}
