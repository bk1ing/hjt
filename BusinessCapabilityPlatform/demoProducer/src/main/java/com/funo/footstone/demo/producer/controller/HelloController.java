package com.funo.footstone.demo.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.funo.footstone.common.service.RedisService;
import com.funo.footstone.demo.producer.entity.User;
import com.funo.footstone.demo.producer.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="HelloController模块")
@RestController
@RefreshScope
public class HelloController
{
	protected static final Logger logger = LoggerFactory.getLogger( HelloController.class );
			
	@Value("${configTestStr1:error}")
//	@Value("${info.profile:error}")
    private String configTestStr1;
	
	@Autowired
    private RedisService redisService;
	@Autowired
	private UserService userService;
	
	/*
	http://localhost:8001/hello?name=abcName
	http://localhost:8001/testProducer/hello
	*/
	@RequestMapping("/hello")
	@ApiOperation(value="helloWorld demo",notes="这是一个测试方法")
	@ApiImplicitParams({
	  	@ApiImplicitParam(name="name",value="这是一个参数",required=false,paramType="query")
	})
	public String index(@RequestParam String name)
	{
		System.out.println( configTestStr1 );
		return "hello " + name + "，this is first messge, "+configTestStr1;
	}
	
	/*
	http://localhost:8001/testTimeoutAndRetry?name=abcName&waitTimeout=2000&retry=2
	*/
	@RequestMapping("/testTimeoutAndRetry")
	@ApiOperation(value="testTimeoutAndRetry demo",notes="这是一个测试方法")
	@ApiImplicitParams({
	  	@ApiImplicitParam(name="name",value="这是一个参数",required=false,paramType="query")
	})
	public String testTimeoutAndRetry(@RequestParam String name, @RequestParam long waitTimeout, @RequestParam int retry)
	{
		String rn ="";
		try
		{
			rn= "demoProducer, testTimeoutAndRetry, " + name + ", waitTimeout="+waitTimeout+", retry="+retry;
			Thread.sleep( waitTimeout );
		}
		catch(Throwable t)
		{
			logger.error("", t);
		}
		return rn;
	}
	
//-----------------------------------------------------------------------------------------------
	
	/*
	http://localhost:8001/testSetRedis?key=k22&value=v22
	 */
	@RequestMapping("/testSetRedis")
	@ApiOperation(value="testSetRedis",notes="testSetRedis note")
	@ApiImplicitParams({
	  	@ApiImplicitParam(name="key",value="这是一个参数",required=true,paramType="query"),
	  	@ApiImplicitParam(name="value",value="这是一个参数",required=true,paramType="query")
	})
	public String testSetRedis(@RequestParam String key, @RequestParam String value)
	{
		redisService.setValue( key, value);
		return "testSetRedis, ok";
	}
	/*
	http://localhost:8001/testGetRedis?key=k1
	 */
	@RequestMapping("/testGetRedis")
	@ApiOperation(value="testGetRedis",notes="testGetRedis note")
	@ApiImplicitParams({
	  	@ApiImplicitParam(name="key",value="这是一个参数",required=true,paramType="query")
	})
	public String testGetRedis(@RequestParam String key)
	{
		return (String)redisService.getValue(key);
	}
	
	
//-----------------------------------------------------------------------------------------------
	/*
	http://localhost:8001/getUser?name=user1
	 */
	@RequestMapping("getUser")
	@ResponseBody
	public User getUser(String name) {
		return userService.getUserByname(name);
	}
}