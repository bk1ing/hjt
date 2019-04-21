package com.funo.footstone.demo.consumer.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.funo.footstone.demo.consumer.service.HelloServiceIF;


@Component
public class HelloServiceHystrix implements HelloServiceIF
{
    public String hello(@RequestParam(value = "name") String name)
    {
    	return "call " +name+" err, this messge send failed ";
    }
    
    public String testTimeoutAndRetry(@RequestParam String name, @RequestParam long waitTimeout, @RequestParam int retry)
    {
    	String rn= "call testTimeoutAndRetry err,  params: " + name + ", waitTimeout="+waitTimeout+", retry="+retry;
    	return rn;
    }
}
