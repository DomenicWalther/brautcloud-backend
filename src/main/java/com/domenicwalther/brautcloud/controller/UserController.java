package com.domenicwalther.brautcloud.controller;

import com.domenicwalther.brautcloud.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    Map<String, User> users = new HashMap<>();

    @GetMapping("/users")
    public Collection<User> getUsers(){
        return users.values();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        users.put(user.getId(), user);
    }
}
