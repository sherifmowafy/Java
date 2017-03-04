package com.sherif.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sherif.model.Event;

@Controller
@RequestMapping("/event")
public class EventController {

	@InitBinder
	public void initbinder(WebDataBinder binder){
		//binder.setDisallowedFields(new String[]{"studentDOB"});
		SimpleDateFormat df = new SimpleDateFormat("yyyy**MM**dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
		//binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(df, true));
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getEvent(){
		return "event";
	}
	
	@RequestMapping(value="/details", method=RequestMethod.GET)
	public String getEventDetails(@SessionAttribute("event") Event e){
		return "eventdetails";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String postEvent(@Valid @ModelAttribute("event") Event e, BindingResult result, HttpSession session){
		if(result.hasErrors()){
			System.err.println("## Data binding error");
			return "event";
		}
		System.out.println(e.getName());
		session.setAttribute("event",e);
		return "redirect:/event/details";
	}
	
	
	
}
