package com.sherif.jms;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sherif.jms.spring.JmsConfig;
import com.sherif.jms.spring.MessageSender;

public class Main {


	public static void main(String[] args) throws InterruptedException {
//		thread(new Consumer(), false);
//		thread(new Producer(), false);
//		thread(new Producer(), false);
//
//		Thread.sleep(10_000L);
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(JmsConfig.class);
		
		MessageSender sender =  context.getBean(MessageSender.class);
		
		sender.sendMessage("Hello Spring JMS World !!!");
		
		
		Thread.sleep(10_000);
		
		System.out.println("end!");
	}

	public static void thread(Runnable runnable, boolean daemon) {
		Thread brokerThread = new Thread(runnable);
		brokerThread.setDaemon(daemon);
		brokerThread.start();
	}

}
