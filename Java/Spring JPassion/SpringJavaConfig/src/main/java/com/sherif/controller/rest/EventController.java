package com.sherif.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sherif.model.Event;

@RestController("eventRest")
@RequestMapping("/events/rest")
public class EventController {

	
	@RequestMapping(method=RequestMethod.GET)
	public List<Event> getEvents(){
		List<Event> events = new ArrayList<>();
		Event evt1 = new Event();
		evt1.setName("Spring 4 Rest Inroduction");
		
		Event evt2 = new Event();
		evt2.setName("Spring 4 Java Config");
		
		events.add(evt1);
		events.add(evt2);
		
//		if(true)
//			throw new NullPointerException("Rest Api Severe Error");
		return events;
	}
	
	
}
