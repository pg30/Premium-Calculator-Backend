package com.pg.premiumcalculator.authentication.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private String username,email;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtResponse(String accessToken, String username, String email,Collection<? extends GrantedAuthority> authorities) {
		this.accessToken = accessToken;
		this.username = username;
		this.email = email;
		this.authorities = authorities;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
		
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}