package com.sherif.service.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomAuthenticationToken implements Authentication {

	private String name;
	private Object credentials;
	private Collection<? extends GrantedAuthority> authorities;
	private boolean authenticated;
	
	private UserDetails userDetails;
	
	public CustomAuthenticationToken(String name, Object credentials){
		this.name = name ;
		this.credentials = credentials;
	}
	
	public CustomAuthenticationToken(UserDetails userDetails, String name, Object credentials, Collection<? extends GrantedAuthority> authorities){
		this(name,credentials);
		this.userDetails = userDetails;
		this.authorities = authorities;
		
	}
	
	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public Object getCredentials() {
		return credentials;
	}

	@Override
	public Object getDetails() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return userDetails;
	}

	@Override
	public boolean isAuthenticated() {
		
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		this.authenticated = isAuthenticated;
	}

}
