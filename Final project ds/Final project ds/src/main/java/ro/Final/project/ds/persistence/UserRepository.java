package ro.Final.project.ds.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ro.Final.project.ds.model.entity.User;

import java.util.List;

@Repository
public interface  UserRepository extends CrudRepository<User,Long>/*, JpaRepository<User,Long>*/ {

    User getUserById(String id);

    User getUserByEmail(String email);
    //User getUserByRa
   //int getr
}
