package com.pg.premiumcalculator.premium;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pg.premiumcalculator.constants.Constants;
import com.pg.premiumcalculator.models.BasicVehicleDetailsPOJO;
import com.pg.premiumcalculator.models.ODPremiumPOJO;
import com.pg.premiumcalculator.models.TPPremiumPOJO;
import com.pg.premiumcalculator.service.PremiumDataService;

@Service
public class Premium {
	private BasicVehicleDetailsPOJO basicVehicleDetailsPOJO;
	private TPPremiumPOJO tpPremiumPOJO;
	private ODPremiumPOJO odPremiumPOJO;
	
    private double 	finalPremium=0,
            		gst=0;
    
	ODPremium odPremium;
	TPPremium tpPremium;
	BasicVehicleDetails basicVehicleDetails;

	DecimalFormat df = new DecimalFormat("0.00");
	
	private static Logger logger = LogManager.getLogger(Premium.class.getName());
	
	LinkedHashMap<String,String> finalData = new LinkedHashMap<>();
		
	public Premium(BasicVehicleDetailsPOJO basicVehicleDetailsPOJO, TPPremiumPOJO tpPremiumPOJO,
			ODPremiumPOJO odPremiumPOJO) {
		super();
		init();
		this.basicVehicleDetailsPOJO = basicVehicleDetailsPOJO;
		this.tpPremiumPOJO = tpPremiumPOJO;
		this.odPremiumPOJO = odPremiumPOJO;
		
		logger.debug("inside premium constructor");
		logger.debug(this.basicVehicleDetailsPOJO.toString());
		logger.debug(this.tpPremiumPOJO.toString());
		logger.debug(this.odPremiumPOJO.toString());
		
		odPremium = new ODPremium(this.odPremiumPOJO, this.basicVehicleDetailsPOJO);
		tpPremium = new TPPremium(this.tpPremiumPOJO, this.basicVehicleDetailsPOJO);
		basicVehicleDetails = new BasicVehicleDetails(this.basicVehicleDetailsPOJO);
	}
	
	void init()
	{
		finalPremium=0;
		gst=0;
	}
	
	public double calculatePremium()
	{
		finalData.clear();
		if(basicVehicleDetailsPOJO.getVehicle().getId()==Constants.GCV_ID || basicVehicleDetailsPOJO.getVehicle().getId()==Constants.GCV_3WHEELER_ID)
		{
		    double finalTpPremium = tpPremium.calculatePremium(),
		            finalOdPremium = odPremium.calculatePremium();
		    
		    finalPremium = finalOdPremium+finalTpPremium;
		    finalData.put("Total Premium without GST",df.format(finalPremium));
		    
		    double basicTP;
		    basicTP = tpPremium.basicTp;
		    gst = (finalPremium-basicTP)*(Constants.GST_RATE/100) + (basicTP)*(Constants.EXTRA_GST_RATE/100);
		    finalData.put("GST",df.format(gst));
		    finalPremium+=gst;
		    finalData.put("Total Premium(A+B)",Double.toString(Math.round(finalPremium)));
		    return finalPremium;
		}
		else
		{
		    double finalTpPremium = tpPremium.calculatePremium(),
		            finalOdPremium = odPremium.calculatePremium();
		    
		    finalPremium = finalOdPremium+finalTpPremium;
		    finalData.put("Total Premium without GST",df.format(finalPremium));
		    
		    gst = finalPremium*(Constants.GST_RATE/100);
		    finalData.put("GST",df.format(gst));
		    
		    finalPremium+=gst;
		    
		    finalData.put("Total Premium(A+B)",Double.toString(Math.round(finalPremium)));
		    return finalPremium;
		}
	}
	public LinkedHashMap<String,String> getFinalData()
	{
	return finalData;
	}
	public LinkedHashMap<String,String> getTPData()
	{
	return tpPremium.getMap();
	}
	public LinkedHashMap<String,String> getODData()
	{
	return odPremium.getMap();
	}
	public LinkedHashMap<String,String> getBasicData()
	{
	return basicVehicleDetails.getMap();
	}

}
