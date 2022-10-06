package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findByKeyword/{keyword}")
    public List<User> getByKeyword(@PathVariable String keyword) {
        return userService.findByKeyword(keyword);
    }

}
