package com.pg.premiumcalculator.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TpPerPassenger")
public class TpPerPassenger {
	@Id
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicleId", referencedColumnName = "id")
	private Vehicle vehicle;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ccId", referencedColumnName = "id")
	private ccRange cc;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passengerId", referencedColumnName = "id")
	private passengerRange passenger;
		
	@Column(name = "cost")
	private Integer cost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ccRange getCc() {
		return cc;
	}

	public void setCc(ccRange cc) {
		this.cc = cc;
	}

	public passengerRange getPassenger() {
		return passenger;
	}

	public void setPassenger(passengerRange passenger) {
		this.passenger = passenger;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
}
