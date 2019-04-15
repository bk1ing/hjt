package com.bk.test.producer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bk.test.producer.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.Authorization;

@Api(value="demo模块", description = "demo模块API", tags = "StudentApi" )
@Controller
@RequestMapping("/demo")
public class DemoController
{
	//返回数据
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1(HttpServletRequest request) {
        System.out.println(request.getRequestURI()); // /demo/test1
        return "eureka客户端返回数据";
    }
 
 
    //返回页面
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String test2(HttpServletRequest request) {
        System.out.println(request.getRequestURI()); // /demo/test2
        return "test";
    }
 
    //返回对象
    @RequestMapping(value = "/test3", method = RequestMethod.GET)
    @ResponseBody
    public User test3(HttpServletRequest request) {
        System.out.println(request.getRequestURI()); // /demo/test3
        User user = new User();
        user.setId("id1");
        user.setName("admin");
        return user;
    }

}
