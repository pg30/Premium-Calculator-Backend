package com.pg.premiumcalculator.models;

public class TPPremiumPOJO {
	
    private double 	paToDriver,
		            llToDriver,
		            paToUnnamedPassenger,
		            nfpp;
		            
    private boolean lessTppd;
    
    public TPPremiumPOJO() {
		// TODO Auto-generated constructor stub
    	init();
	}
    
    void init()
    {
        paToDriver=0;
        llToDriver=0;
        paToUnnamedPassenger=0;
        nfpp=0;
        lessTppd=false;
    }
    
    
    
	@Override
	public String toString() {
		return "TPPremiumPOJO [paToDriver=" + paToDriver + ", llToDriver=" + llToDriver + ", paToUnnamedPassenger="
				+ paToUnnamedPassenger + ", nfpp=" + nfpp + ", lessTppd=" + lessTppd + "]";
	}

	public double getPaToDriver() {
		return paToDriver;
	}

	public void setPaToDriver(double paToDriver) {
		this.paToDriver = paToDriver;
	}

	public double getLlToDriver() {
		return llToDriver;
	}

	public void setLlToDriver(double llToDriver) {
		this.llToDriver = llToDriver;
	}

	public double getPaToUnnamedPassenger() {
		return paToUnnamedPassenger;
	}

	public void setPaToUnnamedPassenger(double paToUnnamedPassenger) {
		this.paToUnnamedPassenger = paToUnnamedPassenger;
	}

	public double getNfpp() {
		return nfpp;
	}

	public void setNfpp(double nfpp) {
		this.nfpp = nfpp;
	}

	public boolean isLessTppd() {
		return lessTppd;
	}

	public void setLessTppd(boolean lessTppd) {
		this.lessTppd = lessTppd;
	}
    
}
