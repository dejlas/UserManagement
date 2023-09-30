package com.kahvana.challenge.controller;

import com.kahvana.challenge.entity.User;
import com.kahvana.challenge.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    UserService userService = new UserService();


    @GetMapping("/users")
    public ResponseEntity<List<User>> viewUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.of(Optional.of(users));
    }

    @GetMapping("/search")
    public ResponseEntity<User> findUser(@RequestParam("id") Long id){
        Optional<User> user = userService.findById(id);
        return ResponseEntity.of(user);
    }

    @PostMapping("/addUsers")
    public ResponseEntity<List<User>> saveUser(@ModelAttribute List<User> users) {
        users.forEach(user -> {
            User newUser = new User();
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setEmail(user.getEmail());
            userService.saveUser(user);
        });
        List<User> allUsers = userService.findAllUsers();
        return ResponseEntity.of(Optional.of(allUsers));
    }
    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(@ModelAttribute User user) {
        User userFromDb = userService.findById(user.getId()).orElseThrow();
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setEmail(user.getEmail());
        userService.saveUser(userFromDb);
        return ResponseEntity.of(Optional.of(userFromDb));
    }
    }
