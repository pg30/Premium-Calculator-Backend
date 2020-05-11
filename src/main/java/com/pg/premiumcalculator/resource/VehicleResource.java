package com.pg.premiumcalculator.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pg.premiumcalculator.models.Vehicle;
import com.pg.premiumcalculator.service.VehicleDataService;

@CrossOrigin(origins = "*")
@RestController
public class VehicleResource {
	
	@Autowired
	VehicleDataService vehicleService;
	
	@GetMapping("/users/{username}/vehicles")
	public List<Vehicle> getAllVehicles(@PathVariable String username)
	{
		return vehicleService.findAll();
	}
	
}
