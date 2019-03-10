package ro.Final.project.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.Final.project.ds.model.entity.Director;
import ro.Final.project.ds.persistence.DirectorRepository;

import java.util.ArrayList;

@Service
public class DirectorService implements IDirectorService {

    private DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository){
        this.directorRepository=directorRepository;
    }

    @Override
    public void createDirector(Director director) {
        this.directorRepository.save(director);
    }

    @Override
    public void updateDirector(Director director) {
        this.directorRepository.save(director);
    }

    @Override
    public void deleteDirector(Director director) {
        this.directorRepository.delete(director);
    }

    @Override
    public Director getDirectorById(Long id) {
        return this.directorRepository.findById(id).get();
    }

    @Override
    public ArrayList<Director> getAllDirectors() {
        ArrayList<Director> listOfDirectors=new ArrayList<>();
        this.directorRepository.findAll().forEach(listOfDirectors::add);

        return listOfDirectors;
    }
}
