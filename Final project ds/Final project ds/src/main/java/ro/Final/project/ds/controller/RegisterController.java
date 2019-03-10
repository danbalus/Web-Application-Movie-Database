package ro.Final.project.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.Final.project.ds.model.entity.User;
import ro.Final.project.ds.service.IUserService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class RegisterController {
    private IUserService userService;

    @Autowired
    public RegisterController(IUserService userService){
        this.userService = userService;

    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        String email =  user.getEmail();
        User user2 = userService.getUserByEmail(email);

        if(user2 == null ) {
            System.out.println("Nu exista userul cu email-ul: "+ email);
            userService.createUser(user);
            System.out.println("S-a creeat userul cu email-ul: "+ email);
            return ResponseEntity.ok(user);
        }

        System.out.println("Exista userul cu email-ul: "+ email);
        return ResponseEntity.ok(user);
    }
}
