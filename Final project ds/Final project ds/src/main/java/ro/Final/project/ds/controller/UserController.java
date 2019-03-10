package ro.Final.project.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.Final.project.ds.model.entity.User;
import ro.Final.project.ds.service.IUserService;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class UserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService){
        this.userService=userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){

        userService.createUser(user);

        return ResponseEntity.ok(user);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user){

        userService.updateUser(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value ="id") Long id){

        User user = userService.getUserById(id);
        userService.deleteUser(user);

        return ResponseEntity.ok(user);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value ="id") Long id){
       // System.out.println(userService.getUserById(id).toString());
        return ResponseEntity.ok(userService.getUserById(id));
    }

//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable(value = "id") String id){
//
//        return ResponseEntity.ok(userService.getUserById(id));
//    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
    }


}
