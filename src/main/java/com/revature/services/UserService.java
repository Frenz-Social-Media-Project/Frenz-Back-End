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

    public List<User> findByName(String keyword) {
        if(!(userRepository.findByFirstNameContaining(keyword).isEmpty())) {
            return userRepository.findByFirstNameContaining(keyword);
        }
        else {
            return userRepository.findByLastNameContaining(keyword);
        }
    }

    public List<User> findByFullName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }
}