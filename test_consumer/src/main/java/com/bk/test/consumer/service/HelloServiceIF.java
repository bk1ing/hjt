package com.bk.test.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bk.test.consumer.service.impl.HelloServiceHystrix;

@FeignClient(name= "testProducer", fallback = HelloServiceHystrix.class)
public interface HelloServiceIF
{
	@RequestMapping(value = "/hello")
//	@RequestMapping(value = "/hello/", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name") String name);
}
