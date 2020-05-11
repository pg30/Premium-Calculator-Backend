package com.pg.premiumcalculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tp")
public class Tp {

	@Id
	@Column(name = "id",nullable = false,unique = true)
	private Integer id;
	
    @Column(name = "vehicleId")
	private Integer vehicleId;
	
    @Column(name = "carrierId")
	private Integer carrierId;
	
    @Column(name = "ccId")
	private Integer ccId;
	
    @Column(name = "passengerId")
	private Integer passengerId;
	
    @Column(name = "weightId")
	private Integer weightId;
	
    @Column(name = "miscUseId")
	private Integer miscUseId;
	
    @Column(name = "miscTypeId")
	private Integer miscTypeId;
	
	@Column(name = "cost",nullable = false)
	private Integer cost;

	public Tp(Integer id, Integer vehicleId, Integer carrierId, Integer ccId, Integer passengerId, Integer weightId,
			Integer miscUseId, Integer miscTypeId, Integer cost) {
		super();
		this.id = id;
		this.vehicleId = vehicleId;
		this.carrierId = carrierId;
		this.ccId = ccId;
		this.passengerId = passengerId;
		this.weightId = weightId;
		this.miscUseId = miscUseId;
		this.miscTypeId = miscTypeId;
		this.cost = cost;
	}

	public Tp() {
		super();
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

	public Integer getMiscUseId() {
		return miscUseId;
	}

	public void setMiscUseId(Integer miscUseId) {
		this.miscUseId = miscUseId;
	}

	public Integer getMiscTypeId() {
		return miscTypeId;
	}

	public void setMiscTypeId(Integer miscTypeId) {
		this.miscTypeId = miscTypeId;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	
}
