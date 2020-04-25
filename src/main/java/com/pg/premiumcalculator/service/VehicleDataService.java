package com.pg.premiumcalculator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.premiumcalculator.models.Vehicle;
import com.pg.premiumcalculator.repository.VehicleRepository;

@Service
public class VehicleDataService {
	
//	private static List<Vehicle> vehicles = new ArrayList<Vehicle>();
//	private static int idCounter = 0;
//	
//	static
//	{
//		vehicles.add(new Vehicle(++idCounter, Constants.TWO_WHEELER_NAME)); //1
//		vehicles.add(new Vehicle(++idCounter, Constants.PRIVATE_CAR_NAME)); //2
//		vehicles.add(new Vehicle(++idCounter, Constants.GCV_NAME)); //3
//		vehicles.add(new Vehicle(++idCounter, Constants.TAXI_NAME)); //4
//		vehicles.add(new Vehicle(++idCounter, Constants.BUS_NAME)); //5
//		vehicles.add(new Vehicle(++idCounter, Constants.SCHOOL_BUS_NAME)); //6
//		vehicles.add(new Vehicle(++idCounter, Constants.GCV_3WHEELER_NAME)); //7
//		vehicles.add(new Vehicle(++idCounter, Constants.PCV_3WHEELER_NAME)); //8
//	}
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<Vehicle> findAll()
	{
		return vehicleRepository.findAll();
	}
}
