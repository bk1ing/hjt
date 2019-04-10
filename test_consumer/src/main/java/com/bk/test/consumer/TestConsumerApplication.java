package com.bk.test.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
//import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker//@EnableHystrix
@RestController
public class TestConsumerApplication
{
	protected static final Logger logger = LoggerFactory.getLogger( TestConsumerApplication.class );
	
	public static void main(String[] args) 
	{
		SpringApplication.run( TestConsumerApplication.class, args);
	}
	
	/*
	http://localhost:8002/home
	*/
	@RequestMapping("/home")
    public String home() {
        return "TestConsumerHome, Hello world";
    }
}
