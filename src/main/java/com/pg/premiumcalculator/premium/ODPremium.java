package com.pg.premiumcalculator.premium;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.pg.premiumcalculator.constants.Constants;
import com.pg.premiumcalculator.models.BasicVehicleDetailsPOJO;
import com.pg.premiumcalculator.models.ODPremiumPOJO;
import com.pg.premiumcalculator.service.PremiumDataService;
import com.pg.premiumcalculator.service.RateDataService;

public class ODPremium {
	private ODPremiumPOJO odPremiumPOJO;
	private BasicVehicleDetailsPOJO basicVehicleDetailsPOJO;
	
	@Autowired
	private RateDataService rateDataService;
	
	private static Logger logger = LogManager.getLogger(ODPremium.class.getName());
	
    public double basicOD=0,
            rate=0,
            additionalOd=0;
    public Integer
            elecRate = Constants.ELEC_RATE,
            imt23Rate = Constants.IMT_RATE,
            geoExt = Constants.GEO_EXT_COST,
            per100Kg = Constants.PER_100KG_COST,
            overturningRate = Constants.OVERTURNING_RATE,
            inbuiltCngRate = Constants.INBUILT_CNG_RATE,
            externalCngRate = Constants.EXTERNAL_CNG_RATE;

	DecimalFormat df = new DecimalFormat("0.00");
	LinkedHashMap<String,String> data = new LinkedHashMap<>();
	
	
	public ODPremium(ODPremiumPOJO odPremiumPOJO, BasicVehicleDetailsPOJO basicVehicleDetailsPOJO) {
		super();
		this.odPremiumPOJO = odPremiumPOJO;
		this.basicVehicleDetailsPOJO = basicVehicleDetailsPOJO;
		init();
	}

	//TODO : initialize rate, additionalOD, 
	void init()
	{
	    basicOD=0;
	    
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
		
	double calculatePremium()
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
	    
	    if(basicVehicleDetailsPOJO.isCng())
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
	    
	    double zerodepprem = basicVehicleDetailsPOJO.getIdv()*(odPremiumPOJO.getZeroDepRate()/100);
	    if(zerodepprem>0)
	        data.put("Zerodep@"+odPremiumPOJO.getZeroDepRate()+"%",df.format(zerodepprem));
	    
	    double tempElec=0;
	    tempElec = odPremiumPOJO.getElec()*(elecRate/100);
	    if(tempElec>0)
	        data.put("Electrical Accessories",df.format(tempElec));
	    
	    double tempNonElec=0;
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
	    
	    double ncbDiscPrem = basicOD*(odPremiumPOJO.getNcb()/100);
	    data.put("NCB@"+odPremiumPOJO.getNcb()+"%",df.format(ncbDiscPrem));
	    basicOD-=ncbDiscPrem;
	    double odDiscPrem = basicOD*(odPremiumPOJO.getOdDisc()/100);
	    data.put("OD Discount@"+odPremiumPOJO.getOdDisc()+"%",df.format(odDiscPrem));
	    basicOD-=odDiscPrem;
	    basicOD+=zerodepprem;
	    if(odPremiumPOJO.isWantGeoExt())
	    {
	        data.put("Geographical Extension",Double.toString(geoExt));
	        basicOD+=geoExt;
	    }
	    if(basicVehicleDetailsPOJO.isCng())
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
