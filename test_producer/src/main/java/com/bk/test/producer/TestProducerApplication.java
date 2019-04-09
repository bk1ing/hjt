package com.bk.test.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
//@RestController
public class TestProducerApplication
{
	protected static final Logger logger = LoggerFactory.getLogger( TestProducerApplication.class );
	
	public static void main(String[] args) 
	{
		SpringApplication.run(TestProducerApplication.class, args);
	}
	
	/*
	http://localhost:8001/testProducerHome2
	http://localhost:8001/testProducer/testProducerHome2
	 */
//	@RequestMapping("/testProducerHome2")
    public String home() {
        return "testProducerHome, Hello world";
    }
}
