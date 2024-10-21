package com.AuthApi.Manas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.AuthApi.Manas.Entity.UserCredential;
import com.AuthApi.Manas.repository.UserCredentialRepository;

@Service
public class AuthService {

	@Autowired
	private UserCredentialRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	public String saveUser(UserCredential credential) {
		credential.setPassword(passwordEncoder.encode(credential.getPassword()));
		repository.save(credential);
		return "user Added to the system";
	}
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}
	
	public boolean checkIfUsernameIsPresent(String username) {
		Optional<UserCredential> userData = repository.findByName(username);
		return userData.isPresent();
	}
	
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

	public boolean checkIfEmailIsPresent(String email) {
		Optional<UserCredential> userData = repository.findByEmail(email);
		return userData.isPresent();
	}
}
