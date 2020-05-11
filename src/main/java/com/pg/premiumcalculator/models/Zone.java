package com.pg.premiumcalculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Zone")
public class Zone {
	
	@Id
	@Column(name = "id",nullable = false,unique = true)
	private Integer id;//1,2,3
	
	@Column(name = "zone_name",nullable = false)
	private String name; //A,B,C
	
	public Zone() {
		super();
	}
	
	public Zone(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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
