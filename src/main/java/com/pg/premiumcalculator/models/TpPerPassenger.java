package com.pg.premiumcalculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TpPerPassenger")
public class TpPerPassenger {
	@Id
	@Column(name = "id",nullable = false,unique = true)
	private Integer id;
	
    @Column(name = "vehicleId")
	private Integer vehicleId;
	
    @Column(name = "ccId")
	private Integer ccId;
	
    @Column(name = "passengerId")
	private Integer passengerId;
		
	@Column(name = "cost",nullable = false)
	private Integer cost;

	public Integer getId() {
		return id;
	}

	public TpPerPassenger(Integer id, Integer vehicleId, Integer ccId, Integer passengerId, Integer cost) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.ccId = ccId;
		this.passengerId = passengerId;
		this.cost = cost;
	}

	public TpPerPassenger() {
		super();
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getCcId() {
		return ccId;
	}

	public void setCcId(Integer ccId) {
		this.ccId = ccId;
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
