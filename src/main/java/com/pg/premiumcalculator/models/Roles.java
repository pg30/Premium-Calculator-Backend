package com.pg.premiumcalculator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Roles {

	@Id
	@Column(name = "id",nullable = false, unique=true)
	private Integer id;	
	
	@Column(name = "role_type",nullable = false)
	private String roleType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
}
