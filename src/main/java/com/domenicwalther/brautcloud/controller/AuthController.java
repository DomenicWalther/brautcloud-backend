package com.domenicwalther.brautcloud.controller;

import com.domenicwalther.brautcloud.dto.AuthRequest;
import com.domenicwalther.brautcloud.dto.AuthResponse;
import com.domenicwalther.brautcloud.model.User;
import com.domenicwalther.brautcloud.repository.UserRepository;
import com.domenicwalther.brautcloud.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;

	private final JwtService jwtService;

	public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager, JwtService jwtService) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody AuthRequest request) {
		if (userRepository.findByEmail(request.email()).isPresent()) {
			return ResponseEntity.badRequest().body("Email already used!");
		}

		User user = new User();
		user.setEmail(request.email());
		user.setPassword(passwordEncoder.encode(request.password()));
		userRepository.save(user);

		return ResponseEntity.ok("User registered successfully");
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
		authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));

		String token = jwtService.generateToken(request.email());
		return ResponseEntity.ok(new AuthResponse(token));
	}

}