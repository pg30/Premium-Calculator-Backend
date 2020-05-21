package com.pg.premiumcalculator.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.premiumcalculator.models.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	Optional<User> findByEmailId(String email);
}
