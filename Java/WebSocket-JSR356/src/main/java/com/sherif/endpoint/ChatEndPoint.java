package com.sherif.endpoint;

import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.sherif.services.ApplicationSessionHandler;

@ServerEndpoint("/chat")
public class ChatEndPoint {
	
	
	private static ApplicationSessionHandler application = new ApplicationSessionHandler();
	
	 public ChatEndPoint() {
		System.out.println("Init Chat End Point");
	 }
	
	@OnOpen
	public void open(Session session){
		application.addSession(session);
	}
	
	@OnClose
	public void close(Session session){
		application.removeSession(session);
	}
	
	@OnMessage
	public void onMessage(String msg, Session session){
		application.sendToAll(msg);
	}
	
	@OnError
	public void onError(Throwable error){
		System.err.println(error.toString());
	}

}