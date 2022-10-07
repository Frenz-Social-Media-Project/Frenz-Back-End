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

    @PostMapping("/update/{email}")
    public User update(@PathVariable("email") String email, @RequestBody User user){
        Optional<User> currentUser= Optional.ofNullable(this.userService.getByEmail(email));
        if(!currentUser.isPresent()){
            return null;
        }
        User current = currentUser.get();
        return this.userService.updateUser(current);
    }
}
