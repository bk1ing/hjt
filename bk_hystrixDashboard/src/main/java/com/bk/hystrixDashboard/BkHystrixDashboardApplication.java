package com.bk.hystrixDashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@RestController
public class BkHystrixDashboardApplication
{
	protected static final Logger logger = LoggerFactory.getLogger(BkHystrixDashboardApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(BkHystrixDashboardApplication.class, args);
	}
	
	/*
	http://localhost:8003/home
	 */
	@RequestMapping("/home")
	public String home()
	{
		return "BkHystrixDashboard, Hello World";
	}

}
