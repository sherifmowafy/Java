package com.sherif.jms;

import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Consumer extends JMSBase implements Runnable, ExceptionListener  {

	public void receive() throws JMSException{
		
		Destination destination = getSession().createQueue("TEST.QUEUE1");
		getConnection().setExceptionListener(this);
		MessageConsumer consumer = getSession().createConsumer(destination);
		consumer.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message)  {
				if (message instanceof TextMessage) {
					TextMessage textMessage = (TextMessage) message;
					String text = null;
					try {
						text = textMessage.getText();
					} catch (JMSException e) {
						e.printStackTrace();
					}
					System.out.println("Received: " + text);
				} else {
					System.out.println("Received: " + message);
				}
				
			}
		});
		//Message message = consumer.receive(1000);
//		if (message instanceof TextMessage) {
//			TextMessage textMessage = (TextMessage) message;
//			String text = textMessage.getText();
//			System.out.println("Received: " + text);
//		} else {
//			System.out.println("Received: " + message);
//		}
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Clean up
		consumer.close();
		getSession().close();
		getConnection().close();

	}


	public void run() {
		try {
			receive();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}


	public void onException(JMSException ex) {
		ex.printStackTrace();
	}
	
	

}
