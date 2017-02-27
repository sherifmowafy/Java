package com.sherif.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sherif.model.Event;

@Controller
@RequestMapping("/event")
@SessionAttributes("event")
public class EventController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String getEvent(ModelMap map){
		Event e = new Event();
		e.setName("Unnamed event ");
		map.addAttribute("event", e);
		if(true)
			throw new NullPointerException("Custom message Here ...");
		return "event";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String postEvent(@ModelAttribute("event") Event e){
		System.out.println(e.getName());
		return "redirect:greeting";
	}
	
	
	
}
