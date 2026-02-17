package com.domenicwalther.brautcloud.service;

import com.domenicwalther.brautcloud.model.User;
import com.domenicwalther.brautcloud.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Iterable<User> allUsers() {
        return userRepository.findAll();
    }
}
