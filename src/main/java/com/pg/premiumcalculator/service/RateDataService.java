package com.pg.premiumcalculator.service;

import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pg.premiumcalculator.constants.Constants;
import com.pg.premiumcalculator.models.BasicVehicleDetailsPOJO;
import com.pg.premiumcalculator.models.Vehicle;
import com.pg.premiumcalculator.repository.RateRepository;

@Service
public class RateDataService {

	@Autowired
	private RateRepository rateRepository;
	private AgeCalculatorService ageCalculatorService;
	
	private static Logger logger = LogManager.getLogger(RateDataService.class.getName());
	
	public Double findRate(BasicVehicleDetailsPOJO basicVehicleDetailsPOJO)
	{
		ageCalculatorService = new AgeCalculatorService();
		
		logger.debug("inside rate data service");
		logger.debug(basicVehicleDetailsPOJO.toString());
		
        String currentDate = (Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"-"+(Calendar.getInstance().get(Calendar.MONTH)+1)+"-"+Calendar.getInstance().get(Calendar.YEAR));
		Integer age = ageCalculatorService.getDays(currentDate, basicVehicleDetailsPOJO.getDateOfRegistration());
		
		logger.debug(currentDate+" "+basicVehicleDetailsPOJO.getDateOfRegistration());
		logger.debug(age);
		
		Vehicle vehicle = basicVehicleDetailsPOJO.getVehicle();
		
		if(vehicle.getId()==Constants.TWO_WHEELER_ID || vehicle.getId()==Constants.PRIVATE_CAR_ID || vehicle.getId()==Constants.TAXI_ID)
			return rateRepository.findRateA(vehicle.getId(), basicVehicleDetailsPOJO.getZone(), basicVehicleDetailsPOJO.getCubicCapacity(), age);
		
		if(vehicle.getId()==Constants.PCV_3WHEELER_ID)
			return rateRepository.findRateB(vehicle.getId(), basicVehicleDetailsPOJO.getZone(), basicVehicleDetailsPOJO.getSeatingCapacity(), age);

		if(vehicle.getId()==Constants.GCV_ID || vehicle.getId()==Constants.GCV_3WHEELER_ID)
			return rateRepository.findRateC(vehicle.getId(), basicVehicleDetailsPOJO.getZone(), basicVehicleDetailsPOJO.getCarrier(), age);
		
		if(vehicle.getId()==Constants.BUS_ID || vehicle.getId()==Constants.SCHOOL_BUS_ID || vehicle.getId()==Constants.MISCELLANEOUS_ID)
			return rateRepository.findRateD(vehicle.getId(), basicVehicleDetailsPOJO.getZone(), age);		
		
		return 0.0;
	}
	
	public Integer findTppd(Vehicle vehicle)
	{
		int id = vehicle.getId();
		if(id==Constants.MISCELLANEOUS_ID) return 200;
		if(id==Constants.SCHOOL_BUS_ID) return 150;
		if(id==Constants.BUS_ID) return 150;
		if(id==Constants.PCV_3WHEELER_ID) return 150;
		if(id==Constants.GCV_3WHEELER_ID) return 150;
		if(id==Constants.TAXI_ID) return 150;
		if(id==Constants.TWO_WHEELER_ID) return 50;
		if(id==Constants.PRIVATE_CAR_ID) return 100;
		if(id==Constants.GCV_ID) return 200;
		return 0;
	}
	
	public Double findAdditionalOd(BasicVehicleDetailsPOJO basDetailsPOJO)
	{
		int id = basDetailsPOJO.getVehicle().getId();
		int passenger = basDetailsPOJO.getSeatingCapacity();
		
		if(id!=Constants.SCHOOL_BUS_ID && id!=Constants.BUS_ID) return 0.0;
		
        if(passenger>=7 && passenger<=18)
            return 350.0;
        else if(passenger>18 && passenger<=36)
            return 450.0;
        else if(passenger>36 && passenger<=60)
            return 550.0;
        else if(passenger>60)
            return 450.0;		
        
		return 0.0;
	}
}
