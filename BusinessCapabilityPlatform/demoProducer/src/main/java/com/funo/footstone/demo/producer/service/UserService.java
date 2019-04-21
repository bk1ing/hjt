package com.funo.footstone.demo.producer.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.funo.footstone.demo.producer.entity.User;


public interface UserService
{
	public User getUser(String id);

	public void deleteUser(String id);
	
	public User getUserByname(String name);

}
