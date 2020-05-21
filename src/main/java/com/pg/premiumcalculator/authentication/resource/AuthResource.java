package com.pg.premiumcalculator.authentication.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pg.premiumcalculator.authentication.jwt.JwtUtil;
import com.pg.premiumcalculator.authentication.models.LoginForm;
import com.pg.premiumcalculator.authentication.models.LoginResponse;

@CrossOrigin(origins = "*")
@RestController
public class AuthResource {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginForm form) throws Exception
	{
		try
		{
			authManager.authenticate(new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()));
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("Invalid credentials");
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(form.getEmail());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new LoginResponse(jwt));
	}
}
