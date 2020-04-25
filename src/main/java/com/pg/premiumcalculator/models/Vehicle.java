package com.pg.premiumcalculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle")
public class Vehicle {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "vehicle_name")
	private String name;
	
	public Vehicle(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Vehicle() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
