package com.bk.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController

@SpringBootApplication
@EnableAdminServer

//public class BkAdminApplication
public class BkAdminApplication extends SpringBootServletInitializer
{
	protected static final Logger logger = LoggerFactory.getLogger(BkAdminApplication.class);

	public static void main(String[] args) 
	{
		SpringApplication.run(BkAdminApplication.class, args);
	}
	/*
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
	{
		return builder.sources(BkAdminApplication.class);
	}
	public static void main(String[] args)
	{
		SpringApplication.run(BkAdminApplication.class, args);
	}
	*/
	
//	public static void main(String[] args) {
//        SpringApplication.run( BkAdminApplication.class, args);
//    }

	/*
	 * http://localhost:8007/home
	 * http://localhost:8001/testProducer/testProducerHome2
	 */
	@RequestMapping("/home")
	public String home()
	{
		return "BkGateway2Home, Hello world";
	}
}
