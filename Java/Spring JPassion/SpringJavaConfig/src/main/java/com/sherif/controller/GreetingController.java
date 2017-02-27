package com.sherif.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class GreetingController {
	
	
	@RequestMapping(value="greeting", method=RequestMethod.GET)
	public String getGreeting(ModelMap model){
		model.addAttribute("hello", "Halla Halla") ;
		return "greeting";
	}

}
