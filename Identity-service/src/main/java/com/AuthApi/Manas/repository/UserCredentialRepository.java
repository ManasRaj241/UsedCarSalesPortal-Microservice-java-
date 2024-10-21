package com.AuthApi.Manas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AuthApi.Manas.Entity.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {

	Optional<UserCredential> findByName(String username);

	Optional<UserCredential> findByEmail(String email);

}
