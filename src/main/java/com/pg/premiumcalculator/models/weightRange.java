package com.pg.premiumcalculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="weightRange")
public class weightRange {
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "start")
	private Double start;
	
	@Column(name = "end")
	private Double end;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getStart() {
		return start;
	}

	public void setStart(Double start) {
		this.start = start;
	}

	public Double getEnd() {
		return end;
	}

	public void setEnd(Double end) {
		this.end = end;
	}
	
	
}
