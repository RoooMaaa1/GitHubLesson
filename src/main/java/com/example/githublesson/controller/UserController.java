package com.example.githublesson.controller;


import com.example.githublesson.entity.User;
import com.example.githublesson.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping()
    public ResponseEntity<User> getUserById(@RequestParam int id){
        return userService.getUserById(id);
    }

    @GetMapping("/info-date")
    public ResponseEntity<String> getDate(){
        LocalDateTime now = LocalDateTime.now();
        return ResponseEntity.status(200).body(now.toString());
    }

    @DeleteMapping()
    public ResponseEntity<User> deleteUserById(@RequestParam int id){
        return userService.deleteUserById(id);
    }
}
