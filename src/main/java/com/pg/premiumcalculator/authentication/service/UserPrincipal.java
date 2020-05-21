package com.pg.premiumcalculator.authentication.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pg.premiumcalculator.models.User;

public class UserPrincipal implements UserDetails {

	private String name,email,password,id;
	private Integer userRole;
	private Long mobileNo;
	private Boolean enabled;
	
	public UserPrincipal(String name, String email, String password, String id, Long mobileNo, Boolean enabled,Integer userRole) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.id = id;
		this.mobileNo = mobileNo;
		this.enabled = enabled;
		this.userRole = userRole;
	}
	
    public static UserPrincipal build(User user) {
        return new UserPrincipal(user.getUserName(),user.getEmailId(),user.getPassword(),user.getUserId()
        		,user.getMobileNo(),user.getEnabled(),user.getUserRole());
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
}
