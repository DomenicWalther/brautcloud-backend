package com.domenicwalther.brautcloud.service;

import com.domenicwalther.brautcloud.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    Map<String, User> users = new HashMap<>();

    public void addUser(String id, User user) {
        users.put(id, user);
    }

    public Collection<User> allUsers() {
        return users.values();
    }
}
