package com.AuthApi.Manas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.AuthApi.Manas.Entity.UserCredential;
import com.AuthApi.Manas.dto.AuthRequest;
import com.AuthApi.Manas.dto.AuthResponse;
import com.AuthApi.Manas.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService service;

	@Autowired
	private AuthenticationManager authManager;

	private AuthResponse response;

	public AuthController() {
		response = new AuthResponse();
	}

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> addNewUser(@RequestBody UserCredential user) {
		boolean isUsernamePresent = service.checkIfUsernameIsPresent(user.getName());
		boolean isEmailPresent = service.checkIfEmailIsPresent(user.getEmail());
		if (isUsernamePresent) {
			response.setMessage("Entered Username Already exists. Try With a new Username");
			response.setSuccess(false);
			new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		if (isEmailPresent) {
			response.setMessage("entered emailId is already registered.");
			response.setSuccess(false);
			new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		service.saveUser(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> getToken(@RequestBody AuthRequest request) {
		Authentication authenticate = authManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		if (authenticate.isAuthenticated()) {
			response.setMessage("user Authenticated Successfully");
			response.setResult(service.generateToken(request.getUsername()));
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setMessage("");
			response.setSuccess(false);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		service.validateToken(token);
		return "Token is valid";
	}
}
