package com.sherif.jms.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component("messageSender")
public class MessageSender {
	
	@Autowired
	private JmsTemplate template;
	
	public void sendMessage(String msg) {
		 
        template.send(new MessageCreator(){
                @Override
                public Message createMessage(Session session) throws JMSException{
                    TextMessage textMessage = session.createTextMessage(msg);
                    System.out.println("Sendng message: "+ msg + " : " + Thread.currentThread().getName());
                    return textMessage;
                }
            });
    }
		
	

}
