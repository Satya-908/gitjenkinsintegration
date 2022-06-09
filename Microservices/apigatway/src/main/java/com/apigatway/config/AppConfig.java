package com.apigatway.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig { 
	@Bean
	@LoadBalanced
	public RestTemplate rt() {
		
		return new RestTemplate();
	}

}
