package com.domenicwalther.brautcloud.controller;

import com.domenicwalther.brautcloud.dto.UserResponse;
import com.domenicwalther.brautcloud.model.User;
import com.domenicwalther.brautcloud.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<UserResponse> getUsers() {
		return userService.allUsers();
	}

	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

}
