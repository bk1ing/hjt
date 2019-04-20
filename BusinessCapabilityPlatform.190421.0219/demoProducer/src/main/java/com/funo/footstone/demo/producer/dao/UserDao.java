package com.funo.footstone.demo.producer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funo.footstone.demo.producer.entity.User;

public interface UserDao extends JpaRepository<User, String>
{
	public User findByName(String name);
}