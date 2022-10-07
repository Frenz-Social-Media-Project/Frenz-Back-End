package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.io.FileDescriptor.err;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User save(User user) {
        return userRepository.save(user);
    }




    // Gavin potential method
    public List<User> findByName(String keyword) {

        if(!(userRepository.findByFirstNameContaining(keyword).isEmpty())) {
            System.err.println("if statement inside find by first name works in the user service");
            return userRepository.findByFirstNameContaining(keyword);

        }
        else {
            System.err.println("else statement for find by last name works in the user service");
            return userRepository.findByLastNameContaining(keyword);
        }
    }

    public List<User> findByFullName(String firstName, String lastName) {
        System.err.println("calling full name service");
        System.err.println(firstName + " " + lastName);
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

}
