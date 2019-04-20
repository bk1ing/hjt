package com.funo.footstone.bkAdmin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController

@SpringBootApplication
@EnableAdminServer

public class BkAdminApplication //extends SpringBootServletInitializer
{
	protected static final Logger logger = LoggerFactory.getLogger(BkAdminApplication.class);

	public static void main(String[] args) 
	{
		SpringApplication.run(BkAdminApplication.class, args);
	}

	/*
	 * http://localhost:8008/homes
	 */
	@RequestMapping("/home")
	public String home()
	{
		return "BkGateway2Home, Hello world";
	}
}
