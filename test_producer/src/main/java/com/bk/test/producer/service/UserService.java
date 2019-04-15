package com.bk.test.producer.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bk.test.producer.entity.User;

@Service
public class UserService
{
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
