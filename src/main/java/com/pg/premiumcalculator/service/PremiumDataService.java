package com.pg.premiumcalculator.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pg.premiumcalculator.models.BasicVehicleDetailsPOJO;
import com.pg.premiumcalculator.models.ODPremiumPOJO;
import com.pg.premiumcalculator.models.PremiumCalculationRequest;
import com.pg.premiumcalculator.models.PremiumCalculationResponse;
import com.pg.premiumcalculator.models.TPPremiumPOJO;
import com.pg.premiumcalculator.premium.Premium;

@Service
public class PremiumDataService {
	
	private BasicVehicleDetailsPOJO basDetailsPOJO;
	private TPPremiumPOJO tpPOJO;
	private ODPremiumPOJO odPOJO;
	
	private static Logger logger = LogManager.getLogger(PremiumDataService.class.getName());
	
	public PremiumCalculationResponse calculatePremium(PremiumCalculationRequest preRequest)
	{
		basDetailsPOJO = preRequest.getBasicVehicleDetailsPOJO();
		tpPOJO = preRequest.getTpPremiumPOJO();
		odPOJO = preRequest.getOdPremiumPOJO();
		
		logger.debug("inside premium data service");
		logger.debug(basDetailsPOJO.toString());
		logger.debug(tpPOJO.toString());
		logger.debug(odPOJO.toString());
		
		Premium premium = new Premium(basDetailsPOJO, tpPOJO, odPOJO);
		@SuppressWarnings("unused")
		double cost = premium.calculatePremium();
		PremiumCalculationResponse preResponse = new PremiumCalculationResponse(premium.getBasicData(), premium.getTPData(), premium.getODData(), premium.getFinalData());
		return preResponse;
	}
	
}
