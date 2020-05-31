package com.pg.premiumcalculator.authentication.service;

import java.rmi.UnknownHostException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javassist.NotFoundException;

import com.pg.premiumcalculator.authentication.jwt.JwtProvider;
import com.pg.premiumcalculator.authentication.models.JwtResponse;
import com.pg.premiumcalculator.authentication.models.LoginForm;
import com.pg.premiumcalculator.models.ResponseMessage;
import com.pg.premiumcalculator.models.User;
import com.pg.premiumcalculator.repository.RolesRepository;
import com.pg.premiumcalculator.repository.UserRepository;
import com.pg.premiumcalculator.authentication.models.SignUpForm;

@Component
public class UserDetailsServiceImpl{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private RolesRepository roleRepo;
    @Autowired
    PasswordEncoder encoder;
	
    public ResponseEntity<?> authenticateUser(LoginForm loginRequest) throws NotFoundException{
        Optional<User> u = userRepository.findByEmailId(loginRequest.getEmail());
		if(u.isPresent() == false)
			throw new NotFoundException("username not found");
		
        if (u.get().getEnabled()) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateJwtToken(authentication);
            UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
            // Update Last Login
            Optional<User> user = userRepository.findByEmailId(loginRequest.getEmail());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            user.get().setLastLogin(simpleDateFormat.format(new Date()));
            userRepository.save(user.get());
            return ResponseEntity.ok(new JwtResponse(jwt, userPrincipal.getName(),userPrincipal.getUsername(), userPrincipal.getAuthorities()));
        } else
            return new ResponseEntity<>(new ResponseMessage("Your Account is not yet activated! Please activate first."), HttpStatus.BAD_REQUEST);
    }
	
    public ResponseEntity<?> registerUser(SignUpForm signUpRequest) throws SQLException, UnknownHostException {
//    	Optional<User> user = 
        if (userRepository.findByEmailId(signUpRequest.getEmail()).isPresent()==true) {
        	System.out.println(signUpRequest.getEmail());
        	return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"), HttpStatus.BAD_REQUEST);
        }
        else if (userRepository.findByMobileNo(signUpRequest.getMobileNo()).isEmpty()==false) {
        	System.out.println(signUpRequest.getMobileNo()+" "+userRepository.findByMobileNo(signUpRequest.getMobileNo()));        	
            return new ResponseEntity<>(new ResponseMessage("Fail -> Mobile Number is already in use!"), HttpStatus.BAD_REQUEST);
        }
        else
        {
            User user = new User(signUpRequest.getName(), signUpRequest.getEmail(),
                    signUpRequest.getPassword(), signUpRequest.getMobileNo(), true,2);
           userRepository.save(user);
           return new ResponseEntity<>(new ResponseMessage("Registration successfull!"), HttpStatus.OK);        	
        }
    }
    
	public String getUserRole(Integer id)
	{
        String userRole = roleRepo.findById(id).get().getRoleType();
        return userRole;
	}
}
