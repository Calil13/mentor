package org.example.springmentor.service;

import org.example.springmentor.client.UserClient;
import org.example.springmentor.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserClient userClient;


    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public User getUser(String name) {
        return userClient.getUser(name);
    }
}
