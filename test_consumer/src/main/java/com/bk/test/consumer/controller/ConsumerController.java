package com.bk.test.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bk.test.consumer.service.HelloServiceIF;

@RestController
public class ConsumerController
{
	@Autowired
	HelloServiceIF helloService;

	/*
	http://localhost:8002/hello/consumerCallA
	 */
	@RequestMapping("/hello/{name}")
	public String index(@PathVariable("name") String name)
	{
		return helloService.hello(name);
//		return "hello " + name + "，this is ConsumerController first messge";
	}
}
