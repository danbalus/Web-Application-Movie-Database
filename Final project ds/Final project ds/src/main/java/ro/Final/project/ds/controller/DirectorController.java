package ro.Final.project.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.Final.project.ds.model.entity.Director;
import ro.Final.project.ds.service.IDirectorService;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class DirectorController {
    private IDirectorService directorService;

    @Autowired
    public DirectorController(IDirectorService directorService){
        this.directorService=directorService;
    }

    @PostMapping("/directors")
    public ResponseEntity<Director> createDirector(@RequestBody Director director){

        directorService.createDirector(director);

        return ResponseEntity.ok(director);
    }

    @PutMapping("/directors")
    public ResponseEntity<Director> updateDirector(@RequestBody Director director){

        directorService.updateDirector(director);

        return ResponseEntity.ok(director);
    }

    @DeleteMapping("/directors")
    public ResponseEntity<Director> deleteDirector(@RequestBody Director director){

        directorService.deleteDirector(director);

        return ResponseEntity.ok(director);
    }

    @GetMapping("/directors/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable(value ="id") Long id){

        return ResponseEntity.ok(directorService.getDirectorById(id));
    }

    @GetMapping("/directors")
    public ResponseEntity<List<Director>> getAllDirectors(){

        return ResponseEntity.ok(directorService.getAllDirectors());
    }
}
