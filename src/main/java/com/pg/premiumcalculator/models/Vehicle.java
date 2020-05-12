package com.pg.premiumcalculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle")
public class Vehicle {
	
	@Id
	@Column(name = "id",nullable = false,unique = true)
	private Integer id;
	
	@Column(name = "vehicle_name",nullable = false)
	private String name;
	
	@Column(name = "url")
	private String url;
	
	public Vehicle(Integer id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
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
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
	
	
}
