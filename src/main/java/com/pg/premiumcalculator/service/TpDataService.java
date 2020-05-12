package com.pg.premiumcalculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.premiumcalculator.constants.Constants;
import com.pg.premiumcalculator.models.BasicVehicleDetailsPOJO;
import com.pg.premiumcalculator.models.Vehicle;
import com.pg.premiumcalculator.repository.TpRepository;

@Service
public class TpDataService {

	@Autowired
	TpRepository tpRepository;
	public Integer findTp(BasicVehicleDetailsPOJO basicDetailsPOJO)
	{
		Vehicle vehicle = basicDetailsPOJO.getVehicle();
		if(vehicle.getId()==Constants.TWO_WHEELER_ID || vehicle.getId()==Constants.PRIVATE_CAR_ID || vehicle.getId()==Constants.TAXI_ID)
			return tpRepository.findTpA(vehicle.getId(), basicDetailsPOJO.getCubicCapacity());
		
		if(vehicle.getId()==Constants.PCV_3WHEELER_ID)
			return tpRepository.findTpB(vehicle.getId(), basicDetailsPOJO.getSeatingCapacity());
		
		if(vehicle.getId()==Constants.GCV_ID)
			return tpRepository.findTpC(vehicle.getId(), basicDetailsPOJO.getCarrier(), basicDetailsPOJO.getGvw());
		
		if(vehicle.getId()==Constants.GCV_3WHEELER_ID)
			return tpRepository.findTpD(vehicle.getId(), basicDetailsPOJO.getCarrier());
		
		if(vehicle.getId()==Constants.BUS_ID || vehicle.getId()==Constants.SCHOOL_BUS_ID)
			return tpRepository.findTpE(vehicle.getId());
		
		if(vehicle.getId()==Constants.MISCELLANEOUS_ID)
			return tpRepository.findTpF(vehicle.getId(),basicDetailsPOJO.getVehicleUse(),basicDetailsPOJO.getVehicleType());
		return 0;
	}
}
