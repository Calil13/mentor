package org.example.springmentor.client;

import org.example.springmentor.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "userClient", url = "https://api.nationalize.io")
public interface UserClient {

    @GetMapping
    User getUser(@RequestParam String name);
}
