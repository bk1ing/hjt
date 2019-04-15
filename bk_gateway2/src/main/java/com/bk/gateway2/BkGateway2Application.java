package com.bk.gateway2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
public class BkGateway2Application
{
	protected static final Logger logger = LoggerFactory.getLogger( BkGateway2Application.class );
	
	public static void main(String[] args) 
	{
		SpringApplication.run(BkGateway2Application.class, args);
	}
	
//	@Bean
//    public TokenFilter tokenFilter() 
//	{
//        return new TokenFilter();
//    }
	
	/*
	http://localhost:8007/home
	http://localhost:8001/testProducer/testProducerHome2
	 */
	@RequestMapping("/home")
    public String home() {
        return "BkGateway2Home, Hello world";
    }
}
