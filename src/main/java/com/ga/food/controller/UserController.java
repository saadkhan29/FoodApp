package com.ga.food.controller;

import com.ga.food.model.User;
import com.ga.food.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/auth/users")
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    public User createUser(@RequestBody User userObject){
        System.out.println("Calling createUser ==> ");
        return userService.createUser(userObject);
    }
}
