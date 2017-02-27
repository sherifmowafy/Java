package com.sherif.services;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.Session;

public class ApplicationSessionHandler {

	private Set<Session> sessions = new HashSet<Session>();

	public void addSession(Session session){
		System.out.println("Adding session " + session.getId());
		sessions.add(session);
	}

	public void removeSession(Session session){
		System.out.println("Removing session " + session.getId());
		sessions.remove(session);
	}
	
	public Session getSessionById(String id){
		for(Session s : sessions){
			if(s.getId().equals(id)) return s;
		}
		return null;
	}
	
	public void sendToAll(String msg){
		for(Session s : sessions){
			try {
				System.out.println("sending msg ("+ msg +") to session # " + s.getId()  );
				s.getBasicRemote().sendText(msg);
				
			} catch (IOException e) {
				System.err.println("Error Sending Message");
				e.printStackTrace();
			}
		}
	}

}
