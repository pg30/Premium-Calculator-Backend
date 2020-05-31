package com.pg.premiumcalculator.authentication.resource;

import java.rmi.UnknownHostException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pg.premiumcalculator.authentication.models.LoginForm;
import com.pg.premiumcalculator.authentication.service.UserDetailsServiceImpl;
import com.pg.premiumcalculator.authentication.models.SignUpForm;


@CrossOrigin(origins = "*")
@RestController
public class AuthResource {

	@Autowired
	private UserDetailsServiceImpl userDetails;
	
	@PostMapping(path = "/login", produces = "application/json")
	public ResponseEntity<?> login(@RequestBody LoginForm form) throws Exception
	{
		return userDetails.authenticateUser(form);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) throws SQLException, UnknownHostException {
		return userDetails.registerUser(signUpRequest);
	}	
}
