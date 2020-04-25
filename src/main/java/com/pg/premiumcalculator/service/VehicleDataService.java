package com.pg.premiumcalculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.premiumcalculator.models.Vehicle;
import com.pg.premiumcalculator.repository.VehicleRepository;

@Service
public class VehicleDataService {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<Vehicle> findAll()
	{
		return vehicleRepository.findAll();
	}
}
