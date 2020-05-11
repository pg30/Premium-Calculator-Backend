package com.pg.premiumcalculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rate")
public class RateModel {
	
	@Id
	@Column(name = "id",nullable = false,unique = true)
	private Integer id;
	
    @Column(name = "vehicleId")
	private Integer vehicleId;
	
    @Column(name = "zoneId")
	private Integer zoneId;
	
    @Column(name = "carrierId")
	private Integer carrierId;
	
    @Column(name = "ccId")
	private Integer ccId;
	
    @Column(name = "dayId")
	private Integer dayId;
	
    @Column(name = "passengerId")
	private Integer passengerId;
	
    @Column(name = "weightId")
	private Integer weightId;
	
	@Column(name = "cost", nullable = false)
	private Double cost;

	public RateModel() {
		super();
	}

	public RateModel(Integer id, Integer vehicleId, Integer zoneId, Integer carrierId, Integer ccId, Integer dayId,
			Integer passengerId, Integer weightId, Double cost) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.zoneId = zoneId;
		this.carrierId = carrierId;
		this.ccId = ccId;
		this.dayId = dayId;
		this.passengerId = passengerId;
		this.weightId = weightId;
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getZoneId() {
		return zoneId;
	}

	public void setZoneId(Integer zoneId) {
		this.zoneId = zoneId;
	}

	public Integer getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(Integer carrierId) {
		this.carrierId = carrierId;
	}

	public Integer getCcId() {
		return ccId;
	}

	public void setCcId(Integer ccId) {
		this.ccId = ccId;
	}

	public Integer getDayId() {
		return dayId;
	}

	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public Integer getWeightId() {
		return weightId;
	}

	public void setWeightId(Integer weightId) {
		this.weightId = weightId;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	
}
