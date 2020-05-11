package com.pg.premiumcalculator.models;


public class BasicVehicleDetailsPOJO {

	private Vehicle vehicle;
	
	private Double 	idv,
					cubicCapacity,
					extCngKit,
					gvw;
	
	private Integer seatingCapacity;
	
	private boolean isCng;
	
	private String 	dateOfRegistration,
					zone,
					carrier,
					vehicleUse,
					vehicleType;
		
    public BasicVehicleDetailsPOJO() {
		// TODO Auto-generated constructor stub
    	init();
	}
    
    
    @Override
	public String toString() {
		return "BasicVehicleDetailsPOJO [vehicle=" + vehicle + ", idv=" + idv + ", cubicCapacity=" + cubicCapacity
				+ ", extCngKit=" + extCngKit + ", gvw=" + gvw + ", seatingCapacity=" + seatingCapacity + ", isCng="
				+ isCng + ", dateOfRegistration=" + dateOfRegistration + ", zone=" + zone + ", carrier=" + carrier
				+ ", vehicleUse=" + vehicleUse + ", vehicleType=" + vehicleType + "]";
	}


	public void init()
    {
    	vehicle = null;
    	idv=0.0;
    	cubicCapacity=0.0;
    	extCngKit=0.0;
    	gvw=0.0;
    	seatingCapacity=0;
    	isCng=false;
    	dateOfRegistration=null;
    	zone=null;
    	carrier=null;
    	vehicleUse=null;
    	vehicleType=null;
    }


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}


	public Double getIdv() {
		return idv;
	}


	public void setIdv(Double idv) {
		this.idv = idv;
	}


	public Double getCubicCapacity() {
		return cubicCapacity;
	}


	public void setCubicCapacity(Double cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}


	public Double getExtCngKit() {
		return extCngKit;
	}


	public void setExtCngKit(Double extCngKit) {
		this.extCngKit = extCngKit;
	}


	public Double getGvw() {
		return gvw;
	}


	public void setGvw(Double gvw) {
		this.gvw = gvw;
	}


	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}


	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}


	public boolean isCng() {
		return isCng;
	}


	public void setCng(boolean isCng) {
		this.isCng = isCng;
	}


	public String getDateOfRegistration() {
		return dateOfRegistration;
	}


	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}


	public String getZone() {
		return zone;
	}


	public void setZone(String zone) {
		this.zone = zone;
	}


	public String getCarrier() {
		return carrier;
	}


	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}


	public String getVehicleUse() {
		return vehicleUse;
	}


	public void setVehicleUse(String vehicleUse) {
		this.vehicleUse = vehicleUse;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	
}
