package com.pg.premiumcalculator.authentication.models;

import javax.validation.constraints.NotBlank;

public class LoginForm {
	
	@NotBlank
	private String email,password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
