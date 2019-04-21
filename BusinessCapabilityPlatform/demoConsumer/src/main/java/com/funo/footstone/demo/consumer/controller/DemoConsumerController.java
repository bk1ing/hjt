package com.funo.footstone.demo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.funo.footstone.demo.consumer.service.HelloServiceIF;

@RestController
public class DemoConsumerController
{
	@Autowired
	private HelloServiceIF helloService;
	
	/*
	http://localhost:8002/hello/home/t1
	 */
	@RequestMapping("/hello/home/{name}")
	public String hello_home(@PathVariable("name") String name)
	{
		return "hello_home, " + name + "，this is ConsumerController first messge";
	}

	/*
	http://localhost:8002/hello/consumerCallA
	 */
	@RequestMapping("/hello/{name}")
	public String index(@PathVariable("name") String name)
	{
//		System.out.println("=========================");
		return helloService.hello(name);
//		return "hello " + name + "，this is ConsumerController first messge";
	}
	
	/*
	http://localhost:8002/testTimeoutAndRetry?name=n1&waitTimeout=20&retry=1
	 */
	@RequestMapping("/testTimeoutAndRetry")
	public String testTimeoutAndRetry(@RequestParam String name, @RequestParam long waitTimeout, @RequestParam int retry)
	{
//		System.out.println("=========================");
		return helloService.testTimeoutAndRetry(name, waitTimeout, retry);
	}
}
