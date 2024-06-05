package com.example.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getMethodName() {
        return userService.getAllUsers();
    }
    

    @PostMapping
    public String registerUser(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return "Username already exists";
        }
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists";
        }
        userService.save(user);
        return "User registered successfully";
    }
}
