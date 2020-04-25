package com.pg.premiumcalculator.models;

public class ODPremiumPOJO {
	private double 	zeroDepRate,
		            elec,
		            nonelec,
		            ncb,
		            odDisc;

	private boolean wantImt23,
	                wantGeoExt,
	                wantOverturning;
	
	void init()
	{
        zeroDepRate=0;
        elec=0;
        nonelec=0;
        ncb=0;
        odDisc=0;		
        wantImt23=false;
        wantGeoExt=false;
        wantOverturning=false;
	}

	public ODPremiumPOJO() {
		// TODO Auto-generated constructor stub
		init();
	}
	

	@Override
	public String toString() {
		return "ODPremiumPOJO [zeroDepRate=" + zeroDepRate + ", elec=" + elec + ", nonelec=" + nonelec + ", ncb=" + ncb
				+ ", odDisc=" + odDisc + ", wantImt23=" + wantImt23 + ", wantGeoExt=" + wantGeoExt
				+ ", wantOverturning=" + wantOverturning + "]";
	}

	public double getZeroDepRate() {
		return zeroDepRate;
	}

	public void setZeroDepRate(double zeroDepRate) {
		this.zeroDepRate = zeroDepRate;
	}

	public double getElec() {
		return elec;
	}

	public void setElec(double elec) {
		this.elec = elec;
	}

	public double getNonelec() {
		return nonelec;
	}

	public void setNonelec(double nonelec) {
		this.nonelec = nonelec;
	}

	public double getNcb() {
		return ncb;
	}

	public void setNcb(double ncb) {
		this.ncb = ncb;
	}

	public double getOdDisc() {
		return odDisc;
	}

	public void setOdDisc(double odDisc) {
		this.odDisc = odDisc;
	}

	public boolean isWantImt23() {
		return wantImt23;
	}

	public void setWantImt23(boolean wantImt23) {
		this.wantImt23 = wantImt23;
	}

	public boolean isWantGeoExt() {
		return wantGeoExt;
	}

	public void setWantGeoExt(boolean wantGeoExt) {
		this.wantGeoExt = wantGeoExt;
	}

	public boolean isWantOverturning() {
		return wantOverturning;
	}

	public void setWantOverturning(boolean wantOverturning) {
		this.wantOverturning = wantOverturning;
	}
	
}
