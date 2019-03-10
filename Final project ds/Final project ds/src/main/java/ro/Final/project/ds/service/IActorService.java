package ro.Final.project.ds.service;

import ro.Final.project.ds.model.entity.Actor;

import java.util.ArrayList;

public interface IActorService {
    void createActor(Actor actor);

    void updateActor(Actor actor);

    void deleteActor(Actor actor);

    Actor getActorById(Long id);

    ArrayList<Actor> getAllActors();
}
