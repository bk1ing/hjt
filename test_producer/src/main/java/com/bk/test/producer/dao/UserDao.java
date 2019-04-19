package com.bk.test.producer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bk.test.producer.entity.User;

public interface UserDao extends JpaRepository<User, String>
{
	public User findByName(String name);
}