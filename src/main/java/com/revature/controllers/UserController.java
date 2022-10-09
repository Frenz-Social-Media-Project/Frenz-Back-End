package com.revature.controllers;
import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {
    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update/{id}")
    public User update(@PathVariable("id") int id, @RequestBody User user) {
        Optional<User> currentUser = Optional.ofNullable(this.userService.getById(id));
        if (!currentUser.isPresent()) {
            return null;
        }
        else {
            User currentUserToBeUpdated = currentUser.get();
            if (user.getFirstName() != null) {
                currentUserToBeUpdated.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                currentUserToBeUpdated.setLastName(user.getLastName());
            }
            if (user.getEmail() != null) {
                if ((userService.emailIsTaken(user.getEmail())) &&!(user.getEmail().equals(currentUserToBeUpdated.getEmail()))) {
                    System.out.println("This email is already exist");
                } else {
                    currentUserToBeUpdated.setEmail(user.getEmail());
                }
            }
            return this.userService.updateUser(currentUserToBeUpdated);
        }
    }
}
