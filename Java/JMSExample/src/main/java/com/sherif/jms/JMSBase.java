package com.sherif.jms;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSBase {
	
	
	public JMSBase(){
		try {
			createConnection();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Connection connection ;
	
	private void createConnection() throws JMSException{
		  //ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");
		
		  this.connection = connectionFactory.createConnection();
	}
	
	protected Session getSession() throws JMSException{
        Session session = null;
        // Create a Connection
        Connection connection = this.getConnection();
        connection.start();
        // Create a Session
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        return session;
	}

	public Connection getConnection() {
		return connection;
	}
	
}
