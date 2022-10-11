package com.revature.controllers;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.services.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;
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

    @PostMapping("/update/{email}")
    public User update(@PathVariable("email") String email, @RequestBody User user){
        Optional<User> currentUser= Optional.ofNullable(this.userService.getByEmail(email));
        if(!currentUser.isPresent()){
            return null;
        }
        User current = currentUser.get();
        return this.userService.updateUser(current);
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

    @GetMapping("/posts/{id}")
    public List<Post> getAllUserPosts(@PathVariable("id") int id){
        return userService.findAllUserPosts(id);
    }

    @DeleteMapping("/delete/{userId}")
    public Post deleteUserPost(@PathVariable("userId") int userId, @RequestBody Post post){
        return this.userService.deletePost(userId, post);
    }

    @PutMapping("/update")
    public ResponseEntity<Post> upsertPost(@RequestBody Post post) {
        return ResponseEntity.ok(this.userService.upsert(post));
    }
}
