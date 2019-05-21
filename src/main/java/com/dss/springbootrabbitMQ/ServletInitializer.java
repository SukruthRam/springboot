package com.dss.springbootrabbitMQ;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		int x = 0;
		return application.sources(SpringbootRabbitMqApplication.class);
	}

}
