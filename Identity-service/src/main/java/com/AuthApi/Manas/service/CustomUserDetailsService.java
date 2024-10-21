package com.AuthApi.Manas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.AuthApi.Manas.Entity.UserCredential;
import com.AuthApi.Manas.repository.UserCredentialRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserCredentialRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserCredential> userData = repository.findByEmail(email);
		return userData.map(CustomUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("email Not found With Name :" + email));

	}

}
