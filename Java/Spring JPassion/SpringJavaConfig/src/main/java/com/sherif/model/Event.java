package com.sherif.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import com.sherif.modelvalidtor.ValidHoppy;

public class Event {

	@Size(min=2, max=6)
	private String name;
	private Date eventDate;
	private List<String> speakers;
	@ValidHoppy(value="football|Swimming|reading|gaming")
	private String hoppy;

	
	public String getHoppy() {
		return hoppy;
	}

	public void setHoppy(String hoppy) {
		this.hoppy = hoppy;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public List<String> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<String> speakers) {
		this.speakers = speakers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
