package com.pg.premiumcalculator.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Tp")
public class Tp {

	@Id
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicleId", referencedColumnName = "id")
	private Vehicle vehicle;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carrierId", referencedColumnName = "id")
	private Carrier carrier;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ccId", referencedColumnName = "id")
	private ccRange cc;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passengerId", referencedColumnName = "id")
	private passengerRange passenger;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weightId", referencedColumnName = "id")
	private weightRange weight;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "miscUseId", referencedColumnName = "id")
	private MiscUse miscUse;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "miscTypeId", referencedColumnName = "id")
	private MiscType miscType;
	
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

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
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

	public weightRange getWeight() {
		return weight;
	}

	public void setWeight(weightRange weight) {
		this.weight = weight;
	}

	public MiscUse getMiscUse() {
		return miscUse;
	}

	public void setMiscUse(MiscUse miscUse) {
		this.miscUse = miscUse;
	}

	public MiscType getMiscType() {
		return miscType;
	}

	public void setMiscType(MiscType miscType) {
		this.miscType = miscType;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
}
