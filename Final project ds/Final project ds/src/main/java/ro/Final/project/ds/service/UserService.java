package ro.Final.project.ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.Final.project.ds.model.entity.User;
import ro.Final.project.ds.persistence.UserRepository;

import java.util.ArrayList;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void createUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void  updateUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public User getUserById(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userRepository.getUserByEmail(email);
    }

//    @Override
//    public User getUserById(String id) {
//        return this.userRepository.getUserById(id);
//    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> listOfUsers=new ArrayList<>();
        this.userRepository.findAll().forEach(listOfUsers::add);

        return listOfUsers;
    }

}
