package com.funo.footstone.demo.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.funo.footstone.demo.producer.dao.UserDao;
import com.funo.footstone.demo.producer.entity.User;
import com.funo.footstone.demo.producer.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;

	public User getUserByname(String name)
	{
		User user = userDao.findByName(name);
		return user;
	}

	@Cacheable(value = "user", key = "#id") // user::0
	public User getUser(String id)
	{
		System.out.println(id + "进入实现类获取数据！");
		User user = new User();
		user.setId(id);
		user.setName("张三");
		user.setAge(18);
		return user;
	}

	@CacheEvict(value = "user", key = "#id", condition = "#id!='1'")
	public void deleteUser(String id)
	{
		System.out.println(id + "进入实现类删除数据！");
	}

}
