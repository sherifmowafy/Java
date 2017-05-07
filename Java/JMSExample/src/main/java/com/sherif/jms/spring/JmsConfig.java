package com.sherif.jms.spring;

import java.util.Arrays;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

@Configuration
@ComponentScan(basePackages={"com.sherif.jms"})
public class JmsConfig {

	private static final String DEFAULT_BROKER_URL = "tcp://0.0.0.0:61616";

	private static final String TEST_QUEUE = "TEST.QUEUE1";

	@Autowired
	private MessageReceiver reseiver;

	@Bean
	public ConnectionFactory connectionFactory(){
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
		//connectionFactory.setTrustedPackages(Arrays.asList("com.websystique.spring"));
		return connectionFactory;
	}

	@Bean
	public MessageListenerContainer getContainer(){
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory());
		container.setDestinationName(TEST_QUEUE);
		container.setMessageListener(reseiver);
		return container;
	}

	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory());
		template.setDefaultDestinationName(TEST_QUEUE);
		return template;
	}

}
