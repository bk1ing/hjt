package com.bk.test.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
	@Value("${configTestStr1:error}")
//	@Value("${info.profile:error}")
    private String configTestStr1;
	
	/*
	http://localhost:8001/hello?name=abcName
	http://localhost:8001/testProducer/hello
	*/
	@RequestMapping("/hello")
	public String index(@RequestParam String name)
	{
		System.out.println( configTestStr1 );
		return "hello " + name + "，this is first messge, "+configTestStr1;
	}
}