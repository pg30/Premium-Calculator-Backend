package com.pg.premiumcalculator.authentication.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pg.premiumcalculator.models.User;
import com.pg.premiumcalculator.repository.UserRepository;

@Service
public class UserDetailsSecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
	@Autowired
	private UserDetailsServiceImpl userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmailId(email);
        user.orElseThrow(
                () -> new UsernameNotFoundException("User Not Found with -> email : " + email));

        String userRole = userService.getUserRole(user.get().getUserRole());
        System.out.println(userRole);
        return UserPrincipal.build(user.get(),userRole);
    }
}
