package com.pg.premiumcalculator.authentication.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pg.premiumcalculator.models.User;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	@JsonIgnore	
	private String password;
	private String id;
	private String userRole;
	private Long mobileNo;
	private Boolean enabled;
    private Collection<? extends GrantedAuthority> authorities;
	
	public UserPrincipal(String name, String email, String password, String id, Long mobileNo, Boolean enabled,String userRole,Collection<? extends GrantedAuthority> authorities) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.id = id;
		this.mobileNo = mobileNo;
		this.enabled = enabled;
		this.userRole = userRole;
        this.authorities = authorities;
	}
	
    public static UserPrincipal build(User user,String userRole) {
//    	String userRole = roleRepo.findById(user.getUserRole()).get().getRoleType();
    	List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
    	auth.add(new SimpleGrantedAuthority(userRole));
        return new UserPrincipal(user.getUserName(),user.getEmailId(),user.getPassword(),user.getUserId()
        		,user.getMobileNo(),user.getEnabled(),userRole,auth);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
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

	//currently there is no feature of account expiration
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

	//currently there is no feature of password expiration
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
		return id.toString();
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

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrincipal user = (UserPrincipal) o;
        return Objects.equals(id, user.id);
    }
}
