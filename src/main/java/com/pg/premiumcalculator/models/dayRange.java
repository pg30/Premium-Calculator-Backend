package com.pg.premiumcalculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dayRange")
public class dayRange {
	
	@Id
	@Column(name = "id",nullable = false,unique = true)
	private Integer id;
	
	@Column(name = "start",nullable = false)
	private Integer start;
	
	@Column(name = "end",nullable = false)
	private Integer end;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
	
	
}
