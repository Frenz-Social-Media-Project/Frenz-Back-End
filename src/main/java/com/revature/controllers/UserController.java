package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search/{keyword}")
    public List<User> getByKeyword(@PathVariable String keyword) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(keyword);

        if(matcher.find()){
            String[] fullName = keyword.split("\\s+");
            return userService.findByFullName(fullName[0], fullName[1]);
        }
        return userService.findByName(keyword);
    }
}
