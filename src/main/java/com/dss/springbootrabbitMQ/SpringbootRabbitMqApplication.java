package com.dss.springbootrabbitMQ;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.config.RabbitMQConfig;
import com.javainuse.model.Employee;
import com.javainuse.service.RabbitMQSender;


@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class SpringbootRabbitMqApplication {

	
	RabbitMQSender rabbitMQSender = new RabbitMQSender();
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	
	@RequestMapping("/")
	@ResponseBody
	public String test() {
		
		rabbitTemplate.convertAndSend(RabbitMQConfig.routingkey, "first message");
		return "Application Deployed";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitMqApplication.class, args);
	}

}
