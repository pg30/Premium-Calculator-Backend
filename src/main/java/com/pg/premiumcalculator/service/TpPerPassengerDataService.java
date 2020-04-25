package com.pg.premiumcalculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.premiumcalculator.constants.Constants;
import com.pg.premiumcalculator.models.BasicVehicleDetailsPOJO;
import com.pg.premiumcalculator.models.Vehicle;
import com.pg.premiumcalculator.repository.TpPerPassengerRepository;

@Service
public class TpPerPassengerDataService {

	@Autowired
	TpPerPassengerRepository tpPassengerRepository;
	
	public Integer findTpPerPassenger(BasicVehicleDetailsPOJO basicDetailsPOJO)
	{
		Vehicle vehicle = basicDetailsPOJO.getVehicle();
		if(vehicle.getId()==Constants.TAXI_ID)
			return tpPassengerRepository.findTpPerPassengerA(vehicle.getId(), basicDetailsPOJO.getCubicCapacity());

		if(vehicle.getId()==Constants.PCV_3WHEELER_ID)
			return tpPassengerRepository.findTpPerPassengerB(vehicle.getId(), basicDetailsPOJO.getSeatingCapacity());
		
		if(vehicle.getId()==Constants.BUS_ID || vehicle.getId()==Constants.SCHOOL_BUS_ID)
			return tpPassengerRepository.findTpPerPassengerC(vehicle.getId());
		
		return 0;
	}
}
