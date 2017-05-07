package com.sherif.jms;

import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;

public class Producer extends JMSBase implements Runnable{
	
	public void send() throws JMSException{
        // Create the destination (Topic or Queue)
        Destination destination = getSession().createQueue("TEST.QUEUE1");
		MessageProducer producer = this.getSession().createProducer(destination);
		
		 producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		 
         // Create a messages
         String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
         TextMessage message = getSession().createTextMessage(text);

         // Tell the producer to send the message
         System.out.println("Sent message: "+ message.hashCode() + " : " + Thread.currentThread().getName());
         producer.send(message);

         // Clean up
         producer.close();
         getSession().close();
         getConnection().close();
         
		
	}

	public void run() {
		
		try {
			send();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
