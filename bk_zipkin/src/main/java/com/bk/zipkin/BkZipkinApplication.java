package com.bk.zipkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableZipkinServer
@RestController
public class BkZipkinApplication
{
	protected static final Logger logger = LoggerFactory.getLogger(BkZipkinApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(BkZipkinApplication.class, args);
//		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
	
	/*
	http://localhost:8000/bkZipkinHome
	 */
	@RequestMapping("/bkZipkinHome")
	public String home()
	{
		return "bkZipkinHome, Hello World";
	}

}
