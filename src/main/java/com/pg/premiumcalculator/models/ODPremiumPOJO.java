package com.pg.premiumcalculator.models;

public class ODPremiumPOJO {
	private Double 	zeroDepRate,
		            elec,
		            nonelec,
		            ncb,
		            odDisc;

	private Boolean wantImt23,
	                wantGeoExt,
	                wantOverturning;
	
	public void init()
	{
        zeroDepRate=0.0;
        elec=0.0;
        nonelec=0.0;
        ncb=0.0;
        odDisc=0.0;		
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

	public Double getZeroDepRate() {
		return zeroDepRate;
	}

	public void setZeroDepRate(Double zeroDepRate) {
		this.zeroDepRate = zeroDepRate;
	}

	public Double getElec() {
		return elec;
	}

	public void setElec(Double elec) {
		this.elec = elec;
	}

	public Double getNonelec() {
		return nonelec;
	}

	public void setNonelec(Double nonelec) {
		this.nonelec = nonelec;
	}

	public Double getNcb() {
		return ncb;
	}

	public void setNcb(Double ncb) {
		this.ncb = ncb;
	}

	public Double getOdDisc() {
		return odDisc;
	}

	public void setOdDisc(Double odDisc) {
		this.odDisc = odDisc;
	}

	public Boolean isWantImt23() {
		return wantImt23;
	}

	public void setWantImt23(Boolean wantImt23) {
		this.wantImt23 = wantImt23;
	}

	public Boolean isWantGeoExt() {
		return wantGeoExt;
	}

	public void setWantGeoExt(Boolean wantGeoExt) {
		this.wantGeoExt = wantGeoExt;
	}

	public Boolean isWantOverturning() {
		return wantOverturning;
	}

	public void setWantOverturning(Boolean wantOverturning) {
		this.wantOverturning = wantOverturning;
	}
	
}
