package com.funo.footstone.demo.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.funo.footstone.demo.consumer.service.impl.HelloServiceHystrix;


@FeignClient(name= "demoProducer", fallback = HelloServiceHystrix.class)
public interface HelloServiceIF
{
	@RequestMapping(value = "/hello")
//	@RequestMapping(value = "/hello/", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name") String name);
	
	@RequestMapping(value = "/testTimeoutAndRetry")
	public String testTimeoutAndRetry(@RequestParam String name, @RequestParam long waitTimeout, @RequestParam int retry);
}
