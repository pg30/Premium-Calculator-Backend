package com.pg.premiumcalculator.premium;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pg.premiumcalculator.constants.Constants;
import com.pg.premiumcalculator.models.BasicVehicleDetailsPOJO;
import com.pg.premiumcalculator.models.ODPremiumPOJO;
import com.pg.premiumcalculator.models.TPPremiumPOJO;
import com.pg.premiumcalculator.service.PremiumDataService;

@Component
public class Premium {
	private BasicVehicleDetailsPOJO basicVehicleDetailsPOJO;
	private TPPremiumPOJO tpPremiumPOJO;
	private ODPremiumPOJO odPremiumPOJO;
	
    private Double 	finalPremium=0.0,
            		gst=0.0;
    
    @Autowired
	private ODPremium odPremium;
    @Autowired
	private TPPremium tpPremium;
    @Autowired
    private BasicVehicleDetails basicVehicleDetails;

	DecimalFormat df = new DecimalFormat("0.00");
	
	private static Logger logger = LogManager.getLogger(Premium.class.getName());
	
	LinkedHashMap<String,String> finalData = new LinkedHashMap<>();
	
	public void init(BasicVehicleDetailsPOJO basicVehicleDetailsPOJO, TPPremiumPOJO tpPremiumPOJO,
			ODPremiumPOJO odPremiumPOJO)
	{
		this.basicVehicleDetailsPOJO = basicVehicleDetailsPOJO;
		this.tpPremiumPOJO = tpPremiumPOJO;
		this.odPremiumPOJO = odPremiumPOJO;
		
		logger.debug("inside premium init");
		logger.debug(this.basicVehicleDetailsPOJO.toString());
		logger.debug(this.tpPremiumPOJO.toString());
		logger.debug(this.odPremiumPOJO.toString());
		
		finalPremium=0.0;
		gst=0.0;
		
		odPremium.init(this.odPremiumPOJO, this.basicVehicleDetailsPOJO);
		tpPremium.init(this.tpPremiumPOJO, this.basicVehicleDetailsPOJO);

		basicVehicleDetails.init(this.basicVehicleDetailsPOJO);
	}
	
	public Double calculatePremium()
	{
		finalData.clear();
		if(basicVehicleDetailsPOJO.getVehicle().getId()==Constants.GCV_ID || basicVehicleDetailsPOJO.getVehicle().getId()==Constants.GCV_3WHEELER_ID)
		{
		    Double finalTpPremium = tpPremium.calculatePremium(),
		            finalOdPremium = odPremium.calculatePremium();
		    
		    finalPremium = finalOdPremium+finalTpPremium;
		    finalData.put("Total Premium without GST",df.format(finalPremium));
		    
		    Double basicTP;
		    basicTP = 1.0*tpPremium.basicTp;
		    gst = (finalPremium-basicTP)*(Constants.GST_RATE/100) + (basicTP)*(Constants.EXTRA_GST_RATE/100);
		    finalData.put("GST",df.format(gst));
		    finalPremium+=gst;
		    finalData.put("Total Premium(A+B)",Double.toString(Math.round(finalPremium)));
		    return finalPremium;
		}
		else
		{
		    Double finalTpPremium = tpPremium.calculatePremium(),
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
