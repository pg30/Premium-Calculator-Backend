package com.pg.premiumcalculator.premium;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Component;

import com.pg.premiumcalculator.constants.Constants;
import com.pg.premiumcalculator.models.BasicVehicleDetailsPOJO;

@Component
public class BasicVehicleDetails {
	
	private BasicVehicleDetailsPOJO basicVehicleDetailsPOJO;

	LinkedHashMap<String,String> data = new LinkedHashMap<>();
    
    public void init(BasicVehicleDetailsPOJO basicVehicleDetailsPOJO) {
		this.basicVehicleDetailsPOJO = basicVehicleDetailsPOJO;
	}
    
    LinkedHashMap<String,String> getMap()
    {
        data.clear();
        
        data.put("Vehicle", basicVehicleDetailsPOJO.getVehicle().getName());
        
        if(basicVehicleDetailsPOJO.getVehicle().getId() == Constants.MISCELLANEOUS_ID)
        {
            data.put("Vehicle Use",basicVehicleDetailsPOJO.getVehicleUse());
            data.put("Vehicle Type",basicVehicleDetailsPOJO.getVehicleType());
        }
        
        if(basicVehicleDetailsPOJO.getVehicle().getId()==Constants.GCV_ID || basicVehicleDetailsPOJO.getVehicle().getId()==Constants.GCV_3WHEELER_ID)
        {
            data.put("Carrier",basicVehicleDetailsPOJO.getCarrier());
        }
        
        data.put("Date of Registration",basicVehicleDetailsPOJO.getDateOfRegistration());
        data.put("Zone",basicVehicleDetailsPOJO.getZone());
        
        if(basicVehicleDetailsPOJO.getVehicle().getId()==Constants.GCV_ID && basicVehicleDetailsPOJO.getGvw()>0)
            data.put("GVW",Double.toString(basicVehicleDetailsPOJO.getGvw()));
        
        data.put("IDV",Double.toString(basicVehicleDetailsPOJO.getIdv()));
        
        if(basicVehicleDetailsPOJO.getVehicle().getId()==Constants.TWO_WHEELER_ID || basicVehicleDetailsPOJO.getVehicle().getId()==Constants.PRIVATE_CAR_ID || basicVehicleDetailsPOJO.getVehicle().getId()==Constants.TAXI_ID)
        {
            if(basicVehicleDetailsPOJO.getCubicCapacity()>0)
                data.put("Cubic Capacity",Double.toString(basicVehicleDetailsPOJO.getCubicCapacity()));
        }
        
        if(basicVehicleDetailsPOJO.getVehicle().getId()==Constants.TAXI_ID || basicVehicleDetailsPOJO.getVehicle().getId()==Constants.BUS_ID || basicVehicleDetailsPOJO.getVehicle().getId()==Constants.SCHOOL_BUS_ID || basicVehicleDetailsPOJO.getVehicle().getId()==Constants.PCV_3WHEELER_ID)
        {
            if(basicVehicleDetailsPOJO.getSeatingCapacity()>=0)
                data.put("Seating Capacity",Double.toString(basicVehicleDetailsPOJO.getSeatingCapacity()));
        }
        
        return data;
    }

}
