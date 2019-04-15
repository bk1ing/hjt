package com.bk.test.producer.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class User implements Serializable
{
	@ApiModelProperty("用户标识id")
	private String id;

	@ApiModelProperty("用户姓名")
	private String name;

	private int age;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}
}
