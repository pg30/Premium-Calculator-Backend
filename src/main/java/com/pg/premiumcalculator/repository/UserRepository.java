package com.pg.premiumcalculator.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pg.premiumcalculator.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	Optional<User> findByEmailId(String email);
	List<User> findByMobileNo(Long mobileNo);
	
}
