package com.sherif.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getIndex(){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value="index", method = RequestMethod.GET)
	public ModelAndView getIndex2(){
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	
	
}
