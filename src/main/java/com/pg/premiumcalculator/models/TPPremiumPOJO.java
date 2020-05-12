package com.pg.premiumcalculator.models;

public class TPPremiumPOJO {
	
    private Double 	paToDriver,
		            llToDriver,
		            paToUnnamedPassenger,
		            nfpp;
		            
    private Boolean lessTppd;
    
    public TPPremiumPOJO() {
		// TODO Auto-generated constructor stub
    	init();
	}
    
    public void init()
    {
        paToDriver=0.0;
        llToDriver=0.0;
        paToUnnamedPassenger=0.0;
        nfpp=0.0;
        lessTppd=false;
    }
    
    
    
	@Override
	public String toString() {
		return "TPPremiumPOJO [paToDriver=" + paToDriver + ", llToDriver=" + llToDriver + ", paToUnnamedPassenger="
				+ paToUnnamedPassenger + ", nfpp=" + nfpp + ", lessTppd=" + lessTppd + "]";
	}

	public Double getPaToDriver() {
		return paToDriver;
	}

	public void setPaToDriver(Double paToDriver) {
		this.paToDriver = paToDriver;
	}

	public Double getLlToDriver() {
		return llToDriver;
	}

	public void setLlToDriver(Double llToDriver) {
		this.llToDriver = llToDriver;
	}

	public Double getPaToUnnamedPassenger() {
		return paToUnnamedPassenger;
	}

	public void setPaToUnnamedPassenger(Double paToUnnamedPassenger) {
		this.paToUnnamedPassenger = paToUnnamedPassenger;
	}

	public Double getNfpp() {
		return nfpp;
	}

	public void setNfpp(Double nfpp) {
		this.nfpp = nfpp;
	}

	public Boolean isLessTppd() {
		return lessTppd;
	}

	public void setLessTppd(Boolean lessTppd) {
		this.lessTppd = lessTppd;
	}
    
}
