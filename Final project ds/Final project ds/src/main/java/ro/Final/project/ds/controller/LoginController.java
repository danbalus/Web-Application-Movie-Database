package ro.Final.project.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.Final.project.ds.model.entity.User;
import ro.Final.project.ds.service.IUserService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
public class LoginController {
    private IUserService userService;

    @Autowired
    public LoginController(IUserService userService){
        this.userService=userService;
    }

    @PostMapping("/login")
    public ResponseEntity<User> getMovieById(@RequestBody User user){
        String userMail = user.getEmail();
        User userFromDB = userService.getUserByEmail(userMail);
        if(userFromDB != null){
            String goodPassword = userFromDB.getPassword();
            String loginUserPassword = user.getPassword();
            if(loginUserPassword.equals(goodPassword)) {
                System.out.println("Userul e in BD. Email: " + userMail);
                return ResponseEntity.ok(userFromDB);
            }
        }
        System.out.println("Eroare logare user");
        return ResponseEntity.badRequest().build();
    }
}
