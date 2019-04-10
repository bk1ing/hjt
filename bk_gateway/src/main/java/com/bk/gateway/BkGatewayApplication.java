package com.bk.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bk.gateway.filter.TokenFilter;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController

@EnableZuulProxy
public class BkGatewayApplication
{
	protected static final Logger logger = LoggerFactory.getLogger( BkGatewayApplication.class );
	
	public static void main(String[] args) 
	{
		SpringApplication.run(BkGatewayApplication.class, args);
	}
	
	@Bean
    public TokenFilter tokenFilter() 
	{
        return new TokenFilter();
    }
	
	/*
	http://localhost:8006/home
	http://localhost:8001/testProducer/testProducerHome2
	 */
	@RequestMapping("/home")
    public String home() {
        return "BkGatewayHome, Hello world";
    }
}
