package com.pg.premiumcalculator.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pg.premiumcalculator.models.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
	@Override
	Optional<Roles> findById(Integer id);
}
