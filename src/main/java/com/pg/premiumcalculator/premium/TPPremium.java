package com.pg.premiumcalculator.premium;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pg.premiumcalculator.constants.Constants;
import com.pg.premiumcalculator.models.BasicVehicleDetailsPOJO;
import com.pg.premiumcalculator.models.TPPremiumPOJO;
import com.pg.premiumcalculator.service.RateDataService;
import com.pg.premiumcalculator.service.TpDataService;
import com.pg.premiumcalculator.service.TpPerPassengerDataService;

@Component
public class TPPremium {
	
	private TPPremiumPOJO tpPremiumPOJO;
	private BasicVehicleDetailsPOJO basicVehicleDetailsPOJO;
	public Integer 	basicTp=0,
					tpPerPassenger=0,
					tppdCost=0;
	public Double 	cngCost=Constants.CNG_COST,
					nfppCost=Constants.NFPP_COST;
	
	@Autowired
	private RateDataService rateService;
	@Autowired
	private TpDataService tpService;
	@Autowired
	private TpPerPassengerDataService tpService2;
	
    DecimalFormat df = new DecimalFormat("0.00");

    LinkedHashMap<String,String> data = new LinkedHashMap<>();
    

	void init(TPPremiumPOJO tpPremiumPOJO, BasicVehicleDetailsPOJO basicVehicleDetailsPOJO)
    {
		this.tpPremiumPOJO = tpPremiumPOJO;
		this.basicVehicleDetailsPOJO = basicVehicleDetailsPOJO;
		
		basicTp=tpService.findTp(basicVehicleDetailsPOJO);
		tpPerPassenger=tpService2.findTpPerPassenger(basicVehicleDetailsPOJO);
		tppdCost=rateService.findTppd(basicVehicleDetailsPOJO.getVehicle());
		
		cngCost=Constants.CNG_COST;
		nfppCost=Constants.NFPP_COST;

    }

    double calculatePremium()
    {
        data.clear();
        
        if(basicTp==0)
        {
            data.put("Basic TP",df.format(basicTp));
            data.put("Final TP Premium(B)",Double.toString(Math.round(basicTp)));
            return 0.0;
        }
        
        double tempBasicTp = basicTp;
        data.put("Basic TP",df.format(tempBasicTp));
        
        tempBasicTp+=basicVehicleDetailsPOJO.getSeatingCapacity()*tpPerPassenger;
        
        if(basicVehicleDetailsPOJO.getSeatingCapacity()>0 && tpPerPassenger>0)
            data.put("TP for seating capacity",df.format(basicVehicleDetailsPOJO.getSeatingCapacity()*tpPerPassenger));

        if(tpPremiumPOJO.getPaToDriver()>0)
            data.put("PA to driver",Double.toString(tpPremiumPOJO.getPaToDriver()));
        
        if(tpPremiumPOJO.getPaToUnnamedPassenger()>0)
            data.put("PA to unnamed passenger",df.format(tpPremiumPOJO.getPaToUnnamedPassenger()));
        
        if(tpPremiumPOJO.getLlToDriver()>0)
            data.put("LL to paid driver",df.format(tpPremiumPOJO.getLlToDriver()));
        
        tempBasicTp+=tpPremiumPOJO.getPaToDriver()+tpPremiumPOJO.getLlToDriver()+tpPremiumPOJO.getPaToUnnamedPassenger();
        
        if(tpPremiumPOJO.isLessTppd()) {
            data.put("Restricted tppd",Double.toString(-tppdCost));
            tempBasicTp -= tppdCost;
        }
        
        if(basicVehicleDetailsPOJO.getWantCng()) {
            data.put("CNG",Double.toString(cngCost));
            tempBasicTp += cngCost;
        }
        
        if(tpPremiumPOJO.getNfpp()>0) {
            tempBasicTp += tpPremiumPOJO.getNfpp() * nfppCost;
            data.put("NFPP",Double.toString(tpPremiumPOJO.getNfpp()*nfppCost));
        }
        
        data.put("Final TP Premium(B)",Double.toString(Math.round(tempBasicTp)));
        return tempBasicTp;
    }
    LinkedHashMap<String,String> getMap()
    {
        return data;
    }

}
