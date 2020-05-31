package com.pg.premiumcalculator.authentication.models;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SignUpForm {

    @NotBlank
	private String name;
    @NotBlank
    @Email
	private String email;
    @NotBlank
	private String password;
    @NotNull
    @Digits(integer = 10, fraction = 0)
	private Long mobileNo;
    
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
    
    
}
