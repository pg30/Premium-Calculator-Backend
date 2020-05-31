package com.pg.premiumcalculator.resource;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pg.premiumcalculator.models.PremiumCalculationRequest;
import com.pg.premiumcalculator.models.PremiumCalculationResponse;
import com.pg.premiumcalculator.service.PremiumDataService;

@CrossOrigin(origins = "*")
@RestController
public class PremiumResource {
	
	@Autowired
	PremiumDataService premiumDataService;
	
	private static Logger logger = LogManager.getLogger(PremiumResource.class.getName());
	
	@PostMapping("/users/{username}/premium")
	public ResponseEntity<PremiumCalculationResponse> calculatePremium(@RequestBody PremiumCalculationRequest premiumCRequest)
	{
		logger.info("premium resource called");
		logger.debug(premiumCRequest.toString());
		
		premiumDataService.setData(premiumCRequest);
		PremiumCalculationResponse preResponse = premiumDataService.calculatePremium();
		return new ResponseEntity<PremiumCalculationResponse>(preResponse,HttpStatus.OK);
	}

}
