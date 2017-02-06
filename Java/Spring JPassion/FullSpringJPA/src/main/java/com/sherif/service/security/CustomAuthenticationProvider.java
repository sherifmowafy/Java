package com.sherif.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("Custom authentication provider called");
		String userName = authentication.getName();
		String password = authentication.getCredentials() ==  null ? "" : authentication.getCredentials().toString() ;
		UserDetails user = customUserDetailsService.loadUserByUsername(userName);
		if(user != null && user.getPassword().equals(password)){
			return new CustomAuthenticationToken(user, userName, password, user.getAuthorities());
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return CustomAuthenticationToken.class.equals(authentication);
	}

}
