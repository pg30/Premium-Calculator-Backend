package com.pg.premiumcalculator.models;


public class BasicVehicleDetailsPOJO {
	/*
	 * vehicle
	 * idv
	 * date of registration
	 * zone
	 * cubic capacity
	 * CNG
	 * Carrier
	 * GVW
	 * seating capacity
	 * vehicle type
	 * vehicle use
	 */
	
	private Vehicle vehicle;
	
	private double 	idv,
					cubicCapacity,
					extCngKit,
					gvw;
	
	private int 	seatingCapacity;
	
	private boolean isCng;
	
	private String 	dateOfRegistration;
	
	private Zone 	zone;
	
	private Carrier carrier;
	
	private MiscUse vehicleUse;
	
    private MiscType vehicleType;
    
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
    	idv=0;
    	cubicCapacity=0;
    	extCngKit=0;
    	gvw=0;
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

	public double getIdv() {
		return idv;
	}

	public void setIdv(double idv) {
		this.idv = idv;
	}

	public double getCubicCapacity() {
		return cubicCapacity;
	}

	public void setCubicCapacity(double cubicCapacity) {
		this.cubicCapacity = cubicCapacity;
	}

	public double getExtCngKit() {
		return extCngKit;
	}

	public void setExtCngKit(double extCngKit) {
		this.extCngKit = extCngKit;
	}

	public double getGvw() {
		return gvw;
	}

	public void setGvw(double gvw) {
		this.gvw = gvw;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
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

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public MiscUse getVehicleUse() {
		return vehicleUse;
	}

	public void setVehicleUse(MiscUse vehicleUse) {
		this.vehicleUse = vehicleUse;
	}

	public MiscType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(MiscType vehicleType) {
		this.vehicleType = vehicleType;
	}
}
