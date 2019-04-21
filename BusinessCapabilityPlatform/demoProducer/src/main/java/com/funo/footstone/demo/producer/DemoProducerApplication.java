package com.funo.footstone.demo.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@EnableCaching
@ComponentScan({"com.funo.footstone"})
@RestController
public class DemoProducerApplication
{
	protected static final Logger logger = LoggerFactory.getLogger( DemoProducerApplication.class );
	
	public static void main(String[] args) 
	{
		SpringApplication.run(DemoProducerApplication.class, args);
	}
	
	/*
	http://localhost:8001/home
	http://localhost:8001/testProducer/testProducerHome2
	 */
	@RequestMapping("/home")
    public String home() {
        return "demoProducerHome, Hello world";
    }
}
