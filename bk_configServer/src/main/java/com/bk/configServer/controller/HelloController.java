package com.bk.configServer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="configServer模块")
@RestController
@RequestMapping("/testHello")
public class HelloController
{
	@Value("${configTestStr1:error}")
//	@Value("${info.profile:error}")
    private String configTestStr1;
	
	/*
	http://localhost:8005/testHello/hello?name=abcName
	http://localhost:8005/testProducer/hello
	*/
	@RequestMapping("/hello")
	@ApiOperation(value="helloWorld demo",notes="这是一个测试方法")
    @ApiImplicitParams({
    	@ApiImplicitParam(name="msg",value="这是一个参数",required=false,paramType="query")
    })
	public String index(@RequestParam String name)
	{
		System.out.println( configTestStr1 );
		return "hello " + name + "，this is BkConfigServer, "+configTestStr1;
	}
}