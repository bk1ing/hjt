package com.bk.test.producer.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bk.test.producer.entity.User;


public interface UserService
{
	public User getUser(String id);

	public void deleteUser(String id);
	
	public User getUserByname(String name);

}
