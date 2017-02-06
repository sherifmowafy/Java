package com.sherif.service.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

//@Component
public class CustomAuthenticationFilter extends GenericFilterBean {

//	@Autowired
//	@Qualifier("authenticationManager")
//	private AuthenticationManager authenticationManager;
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		System.out.println("Custom authentication filter called");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = httpRequest.getHeader("Authentication");
		
		if(token != null){
			//Authentication auth = this.authenticationManager.authenticate(new CustomAuthenticationToken("sherifmwafy@gmail.com", "123")) ;
			Authentication auth = new CustomAuthenticationToken("CustomToken-"+token, "123") ;
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		filterChain.doFilter(request, response);

	}

}
