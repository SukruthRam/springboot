package com.javainuse.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.javainuse.model.Employee;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	
	private String exchange = "javainuse.direct";
	

	private String routingkey = "javainuse.queue";	
	
	
	public void send(Employee company) {
		amqpTemplate.convertAndSend("javainuse.direct", "javainuse.queue", company);
		System.out.println("Send msg = " + company);
	    
	}
}