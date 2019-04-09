package com.bk.configServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@EnableConfigServer
public class BkConfigServerApplication
{
	protected static final Logger logger = LoggerFactory.getLogger( BkConfigServerApplication.class );
	
	public static void main(String[] args) 
	{
		SpringApplication.run( BkConfigServerApplication.class, args);
	}
}
