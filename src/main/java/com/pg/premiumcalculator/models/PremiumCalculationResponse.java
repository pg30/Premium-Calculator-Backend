package com.pg.premiumcalculator.models;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class PremiumCalculationResponse {
	LinkedHashMap<String, String> basData,tpData,odData,finalData;
	List<String> bas,tp,od,fin;

	public PremiumCalculationResponse(LinkedHashMap<String, String> basData, LinkedHashMap<String, String> tpData,
			LinkedHashMap<String, String> odData, LinkedHashMap<String, String> finalData) {
		super();
		this.basData = basData;
		this.tpData = tpData;
		this.odData = odData;
		this.finalData = finalData;
		bas = new ArrayList<String>(basData.keySet());
		tp = new ArrayList<String>(tpData.keySet());
		od = new ArrayList<String>(odData.keySet());
		fin = new ArrayList<String>(finalData.keySet());
	}
	
	public List<String> getBas() {
		return bas;
	}

	public void setBas(List<String> bas) {
		this.bas = bas;
	}

	public List<String> getTp() {
		return tp;
	}

	public void setTp(List<String> tp) {
		this.tp = tp;
	}

	public List<String> getOd() {
		return od;
	}

	public void setOd(List<String> od) {
		this.od = od;
	}

	public List<String> getFin() {
		return fin;
	}

	public void setFin(List<String> fin) {
		this.fin = fin;
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
