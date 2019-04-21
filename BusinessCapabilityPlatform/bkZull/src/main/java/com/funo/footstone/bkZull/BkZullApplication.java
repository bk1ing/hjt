package com.funo.footstone.bkZull;

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


@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
@EnableZuulProxy
public class BkZullApplication
{
	protected static final Logger logger = LoggerFactory.getLogger( BkZullApplication.class );
	
	public static void main(String[] args) 
	{
		SpringApplication.run(BkZullApplication.class, args);
	}
	
//	@Bean
//    public TokenFilter tokenFilter() 
//	{
//        return new TokenFilter();
//    }
	
	/*
	http://localhost:8006/home
	 */
	@RequestMapping("/home")
    public String home() {
        return "BkZullHome, Hello world";
    }
}
