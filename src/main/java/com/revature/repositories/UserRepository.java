package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);





    // Gavin potential method
    List<User> findByFirstNameContaining(String keyword);
    List<User> findByLastNameContaining(String keyword);

//    @Query(value = "SELECT * FROM users WHERE first_name like ?1 AND last_name like ?2", nativeQuery = true)
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
}
