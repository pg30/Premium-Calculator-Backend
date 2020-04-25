package com.pg.premiumcalculator.models;

public class PremiumCalculationRequest {
	private BasicVehicleDetailsPOJO basicVehicleDetailsPOJO;
	private TPPremiumPOJO tpPremiumPOJO;
	private ODPremiumPOJO odPremiumPOJO;
	
	public PremiumCalculationRequest(BasicVehicleDetailsPOJO basicVehicleDetailsPOJO, TPPremiumPOJO tpPremiumPOJO,
			ODPremiumPOJO odPremiumPOJO) {
		super();
		this.basicVehicleDetailsPOJO = basicVehicleDetailsPOJO;
		this.tpPremiumPOJO = tpPremiumPOJO;
		this.odPremiumPOJO = odPremiumPOJO;
	}

	public BasicVehicleDetailsPOJO getBasicVehicleDetailsPOJO() {
		return basicVehicleDetailsPOJO;
	}

	public void setBasicVehicleDetailsPOJO(BasicVehicleDetailsPOJO basicVehicleDetailsPOJO) {
		this.basicVehicleDetailsPOJO = basicVehicleDetailsPOJO;
	}

	public TPPremiumPOJO getTpPremiumPOJO() {
		return tpPremiumPOJO;
	}

	public void setTpPremiumPOJO(TPPremiumPOJO tpPremiumPOJO) {
		this.tpPremiumPOJO = tpPremiumPOJO;
	}

	public ODPremiumPOJO getOdPremiumPOJO() {
		return odPremiumPOJO;
	}

	public void setOdPremiumPOJO(ODPremiumPOJO odPremiumPOJO) {
		this.odPremiumPOJO = odPremiumPOJO;
	}
		
}
