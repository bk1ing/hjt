package com.bk.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
public class BkEurekaApplication
{
	protected static final Logger logger = LoggerFactory.getLogger(BkEurekaApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(BkEurekaApplication.class, args);
//		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
	
	/*
	http://localhost:8000/bkEurekaHome
	 */
	@RequestMapping("/bkEurekaHome")
	public String home()
	{
		return "bkEurekaHome, Hello World";
	}

}
