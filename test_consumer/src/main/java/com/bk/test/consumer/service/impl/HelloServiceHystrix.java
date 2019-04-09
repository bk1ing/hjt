package com.bk.test.consumer.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.bk.test.consumer.service.HelloServiceIF;

@Component
public class HelloServiceHystrix implements HelloServiceIF
{
    public String hello(@RequestParam(value = "name") String name)
    {
    	return "hello" +name+", this messge send failed ";
    }
}
