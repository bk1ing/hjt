package com.bk.configServer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient

@EnableCircuitBreaker

@RestController

@EnableConfigServer
@RefreshScope

//@ComponentScan({"com.bk.common","com.bk.configServer"})
@ComponentScan({"com.bk"})
public class BkConfigServerApplication
{
	protected static final Logger logger = LoggerFactory.getLogger( BkConfigServerApplication.class );
	
	public static void main(String[] args) 
	{
		SpringApplication.run( BkConfigServerApplication.class, args);
	}
	
	@RequestMapping("/home")
    public String home() {
        return "BkConfigServerHome, Hello world";
    }
}
