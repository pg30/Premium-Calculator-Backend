package com.pg.premiumcalculator.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

@Entity
@Table
public class User {
	
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;
    
    @NotBlank
    @Column(name = "user_name",nullable = false)
    private String userName;

    @NaturalId
    @NotBlank
    @Email
    @Column(name = "email_id",nullable = false,unique = true)
    private String emailId;
    
    @Column(name = "password",nullable = false)
    private String password;
    
    @Column(name = "mobile_no",nullable = false,unique = true)
    private Long mobileNo;
    
    @Column(name = "enabled",nullable = false)
    private Boolean enabled;
    
	@Column(name = "reset_token")
    private String resetToken;
    
	@Column(name = "reset_token_expiry")
    private Date resetTokenExpiry;    
	
	@Column(name = "activation_token")
    private String activationToken;
    
	@Column(name = "activation_token_expiry")
    private Date activationTokenExpiry;    
	
	@Column(name = "user_role",nullable = false)
	private Integer userRole;
	
	@Column(name = "last_login")
	private String lastLogin;
	
	public User()
	{
		
	}

	public User(@NotBlank String userName, @NotBlank @Email String emailId, String password,
			Long mobileNo, Boolean enabled,Integer userRole)
	{
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.enabled = enabled;
		this.userRole = userRole;
	}
	public User(String userId, @NotBlank String userName, @NotBlank @Email String emailId, String password,
			Long mobileNo, Boolean enabled, String resetToken, Date resetTokenExpiry, String activationToken,
			Date activationTokenExpiry, Integer userRole, String lastLogin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.enabled = enabled;
		this.resetToken = resetToken;
		this.resetTokenExpiry = resetTokenExpiry;
		this.activationToken = activationToken;
		this.activationTokenExpiry = activationTokenExpiry;
		this.userRole = userRole;
		this.lastLogin = lastLogin;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public Date getResetTokenExpiry() {
		return resetTokenExpiry;
	}

	public void setResetTokenExpiry(Date resetTokenExpiry) {
		this.resetTokenExpiry = resetTokenExpiry;
	}

	public String getActivationToken() {
		return activationToken;
	}

	public void setActivationToken(String activationToken) {
		this.activationToken = activationToken;
	}

	public Date getActivationTokenExpiry() {
		return activationTokenExpiry;
	}

	public void setActivationTokenExpiry(Date activationTokenExpiry) {
		this.activationTokenExpiry = activationTokenExpiry;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	
}
