package com.pg.premiumcalculator.models;

import java.util.LinkedHashMap;

public class PremiumCalculationResponse {
	LinkedHashMap<String, String> basData,tpData,odData,finalData;

	public PremiumCalculationResponse(LinkedHashMap<String, String> basData, LinkedHashMap<String, String> tpData,
			LinkedHashMap<String, String> odData, LinkedHashMap<String, String> finalData) {
		super();
		this.basData = basData;
		this.tpData = tpData;
		this.odData = odData;
		this.finalData = finalData;
	}

	public LinkedHashMap<String, String> getBasData() {
		return basData;
	}

	public void setBasData(LinkedHashMap<String, String> basData) {
		this.basData = basData;
	}

	public LinkedHashMap<String, String> getTpData() {
		return tpData;
	}

	public void setTpData(LinkedHashMap<String, String> tpData) {
		this.tpData = tpData;
	}

	public LinkedHashMap<String, String> getOdData() {
		return odData;
	}

	public void setOdData(LinkedHashMap<String, String> odData) {
		this.odData = odData;
	}

	public LinkedHashMap<String, String> getFinalData() {
		return finalData;
	}

	public void setFinalData(LinkedHashMap<String, String> finalData) {
		this.finalData = finalData;
	}
	
	
}
