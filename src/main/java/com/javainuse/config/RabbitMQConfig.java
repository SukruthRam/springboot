package com.javainuse.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javainuse.listner.Receiver;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

@Configuration
public class RabbitMQConfig {

	
	String queueName = "javainuse.queue";

	
	String exchange = "javainuse.direct";

	
	public static String routingkey = "javainuse.queue" ;

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingkey);
	}

	 @Bean
	    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	            MessageListenerAdapter listenerAdapter) {
	        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	        container.setConnectionFactory(connectionFactory);
	        container.setQueueNames(queueName);
	        container.setMessageListener(listenerAdapter);
	        return container;
	    }

	    @Bean
	    MessageListenerAdapter listenerAdapter(Receiver receiver) {
	        return new MessageListenerAdapter(receiver, "onMessage");
	    }
	

	
}
