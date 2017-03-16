package com.sherif.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/testconn")
public class JdbcTemplateController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping(method=RequestMethod.GET)
	public String testConnection(){
		try {
			return jdbcTemplate.getDataSource().getConnection().getNetworkTimeout() + "";
		} catch (SQLException e) {
			e.printStackTrace();
			return "error" ;
		}
	}
	

}
