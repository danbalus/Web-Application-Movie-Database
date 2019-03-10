package ro.Final.project.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.Final.project.ds.model.entity.Actor;
import ro.Final.project.ds.persistence.ActorRepository;

import java.util.ArrayList;

@Service
public class ActorService implements IActorService {

    private ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository){
        this.actorRepository=actorRepository;
    }

    @Override
    public void createActor(Actor actor) {
        this.actorRepository.save(actor);
    }

    @Override
    public void updateActor(Actor actor) {
        this.actorRepository.save(actor);
    }

    @Override
    public void deleteActor(Actor actor) {
        this.actorRepository.delete(actor);
    }

    @Override
    public Actor getActorById(Long id) {
        return this.actorRepository.findById(id).get();
    }

    @Override
    public ArrayList<Actor> getAllActors() {
        ArrayList<Actor> listOfActors=new ArrayList<>();
        this.actorRepository.findAll().forEach(listOfActors::add);

        return listOfActors;
    }
}
