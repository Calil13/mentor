package org.example.springmentor.controller;

import org.example.springmentor.client.UserClient;
import org.example.springmentor.model.User;
import org.example.springmentor.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User getUser(@RequestParam String name) {
        return userService.getUser(name);
    }
}
