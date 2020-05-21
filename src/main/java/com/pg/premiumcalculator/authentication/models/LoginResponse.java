package com.pg.premiumcalculator.authentication.models;

public class LoginResponse {
	private String jwt;

	public LoginResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
}
