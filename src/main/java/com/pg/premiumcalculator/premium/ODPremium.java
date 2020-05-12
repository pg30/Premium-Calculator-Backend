package com.pg.premiumcalculator.premium;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pg.premiumcalculator.constants.Constants;
import com.pg.premiumcalculator.models.BasicVehicleDetailsPOJO;
import com.pg.premiumcalculator.models.ODPremiumPOJO;
import com.pg.premiumcalculator.service.RateDataService;

@Component
public class ODPremium {
	private ODPremiumPOJO odPremiumPOJO;
	private BasicVehicleDetailsPOJO basicVehicleDetailsPOJO;
	
	@Autowired
	private RateDataService rateDataService;
	
	private static Logger logger = LogManager.getLogger(ODPremium.class.getName());
	
    public Double 	basicOD=0.0,
    				rate=0.0,
    				additionalOd=0.0,
		            elecRate = Constants.ELEC_RATE,
		            imt23Rate = Constants.IMT_RATE,
		            geoExt = Constants.GEO_EXT_COST,
		            per100Kg = Constants.PER_100KG_COST,
		            overturningRate = Constants.OVERTURNING_RATE,
		            inbuiltCngRate = Constants.INBUILT_CNG_RATE,
		            externalCngRate = Constants.EXTERNAL_CNG_RATE;

	DecimalFormat df = new DecimalFormat("0.00");
	LinkedHashMap<String,String> data = new LinkedHashMap<>();

	
	void init(ODPremiumPOJO odPremiumPOJO, BasicVehicleDetailsPOJO basicVehicleDetailsPOJO)
	{
		
		this.odPremiumPOJO = odPremiumPOJO;
		this.basicVehicleDetailsPOJO = basicVehicleDetailsPOJO;
		
	    basicOD=0.0;
	    
	    logger.debug("inside od premium init");
	    logger.debug(basicVehicleDetailsPOJO.toString());
	    
	    rate=rateDataService.findRate(basicVehicleDetailsPOJO);
	    additionalOd=rateDataService.findAdditionalOd(basicVehicleDetailsPOJO);
	    
	    elecRate = Constants.ELEC_RATE;
	    imt23Rate = Constants.IMT_RATE;
	    geoExt = Constants.GEO_EXT_COST;
	    per100Kg = Constants.PER_100KG_COST;
	    overturningRate = Constants.OVERTURNING_RATE;
	    inbuiltCngRate = Constants.INBUILT_CNG_RATE;
	    externalCngRate = Constants.EXTERNAL_CNG_RATE;
	}
		
	Double calculatePremium()
	{
	    data.clear();
	    data.put("Rate",Double.toString(rate));
	    
	    basicOD = basicVehicleDetailsPOJO.getIdv()*(rate/100);
	    basicOD+=additionalOd;	    
	    data.put("Basic OD",df.format(basicOD));

	    if(basicVehicleDetailsPOJO.getIdv()==0) {
	        basicOD=0.0;
	        data.put("Final OD Premium(B)",df.format(basicOD));
	        return basicOD;
	    }
	    
	    if(basicVehicleDetailsPOJO.getWantCng())
	    {
	        //inbuilt
	        if(basicVehicleDetailsPOJO.getExtCngKit()==0)
	        {
	            data.put("Inbuilt CNG",df.format(((inbuiltCngRate/100)*basicOD)));
	            basicOD+=(inbuiltCngRate/100)*basicOD;
	        }
	        
	        //external
	        else if(basicVehicleDetailsPOJO.getExtCngKit()>0)
	        {
	            data.put("External CNG",df.format(((externalCngRate/100)*basicVehicleDetailsPOJO.getExtCngKit())));
	            if(basicVehicleDetailsPOJO.getVehicle().getId()!=Constants.PRIVATE_CAR_ID) {
	                basicOD += (externalCngRate / 100) * basicVehicleDetailsPOJO.getExtCngKit();
	            }
	        }
	    }
	    
	    if(basicVehicleDetailsPOJO.getGvw()-12000>0)
	    {
	        basicOD+=((basicVehicleDetailsPOJO.getGvw()-12000)/100)*per100Kg;
	        data.put("Extra cost per 100kg",df.format((((basicVehicleDetailsPOJO.getGvw()-12000)/100)*per100Kg)));
	    }
	    
	    Double zerodepprem = basicVehicleDetailsPOJO.getIdv()*(odPremiumPOJO.getZeroDepRate()/100);
	    if(zerodepprem>0)
	        data.put("Zerodep@"+odPremiumPOJO.getZeroDepRate()+"%",df.format(zerodepprem));
	    
	    Double tempElec=0.0;
	    tempElec = odPremiumPOJO.getElec()*(elecRate/100);
	    if(tempElec>0)
	        data.put("Electrical Accessories",df.format(tempElec));
	    
	    Double tempNonElec=0.0;
	    tempNonElec = odPremiumPOJO.getNonelec()*(rate/100);
	    if(tempNonElec>0)
	        data.put("Non-Electrical Accessories",df.format(tempNonElec));
	    basicOD+=tempElec+tempNonElec;
	    
	    if(odPremiumPOJO.isWantImt23())
	    {
	        data.put("IMT-23",df.format((basicOD*(imt23Rate/100))));
	        basicOD+=basicOD*(imt23Rate/100);
	    }
	    
	    if(odPremiumPOJO.isWantOverturning())
	    {
	        data.put("Overturning",df.format(((overturningRate/100)*basicVehicleDetailsPOJO.getIdv())));
	        basicOD+=(overturningRate/100)*basicVehicleDetailsPOJO.getIdv();
	    }
	    
	    Double ncbDiscPrem = basicOD*(odPremiumPOJO.getNcb()/100);
	    data.put("NCB@"+odPremiumPOJO.getNcb()+"%",df.format(ncbDiscPrem));
	    basicOD-=ncbDiscPrem;
	    Double odDiscPrem = basicOD*(odPremiumPOJO.getOdDisc()/100);
	    data.put("OD Discount@"+odPremiumPOJO.getOdDisc()+"%",df.format(odDiscPrem));
	    basicOD-=odDiscPrem;
	    basicOD+=zerodepprem;
	    if(odPremiumPOJO.isWantGeoExt())
	    {
	        data.put("Geographical Extension",Double.toString(geoExt));
	        basicOD+=geoExt;
	    }
	    if(basicVehicleDetailsPOJO.getWantCng())
	    {
	        //external
	        if(basicVehicleDetailsPOJO.getExtCngKit()>0 && basicVehicleDetailsPOJO.getVehicle().getId()==Constants.PRIVATE_CAR_ID)
	        {
	            basicOD+=(externalCngRate/100)*basicVehicleDetailsPOJO.getExtCngKit();
	        }
	    }
	    data.put("Final OD Premium(A)",Double.toString(Math.round(basicOD)));
	    return basicOD;
	}
	LinkedHashMap<String,String> getMap()
	{
	    return data;
	}

}
