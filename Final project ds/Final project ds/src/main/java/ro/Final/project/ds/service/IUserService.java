package ro.Final.project.ds.service;

import ro.Final.project.ds.model.entity.User;

import java.util.ArrayList;

public interface IUserService {

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    User getUserById(Long id);

   // User getUserById(String id);
   User getUserByEmail(String id);
    ArrayList<User> getAllUsers();
}
