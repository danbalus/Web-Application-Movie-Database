package ro.Final.project.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.Final.project.ds.model.entity.Actor;
import ro.Final.project.ds.service.IActorService;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class ActorController {
    private IActorService actorService;

    @Autowired
    public ActorController(IActorService actorService){
        this.actorService=actorService;
    }

    @PostMapping("/actors")
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor){

        actorService.createActor(actor);

        return ResponseEntity.ok(actor);
    }

    @PutMapping("/actors")
    public ResponseEntity<Actor> updateActor(@RequestBody Actor actor){

        actorService.updateActor(actor);

        return ResponseEntity.ok(actor);
    }

    @DeleteMapping("/actors")
    public ResponseEntity<Actor> deleteActor(@RequestBody Actor actor){

        actorService.deleteActor(actor);

        return ResponseEntity.ok(actor);
    }

    @GetMapping("/actors/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable(value ="id") Long id){

        return ResponseEntity.ok(actorService.getActorById(id));
    }

    @GetMapping("/actors")
    public ResponseEntity<List<Actor>> getAllActors(){

        return ResponseEntity.ok(actorService.getAllActors());
    }
}
