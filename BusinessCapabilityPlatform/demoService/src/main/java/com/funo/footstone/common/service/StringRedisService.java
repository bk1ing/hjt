package com.funo.footstone.common.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.funo.footstone.common.tools.JsonUtils;

public class StringRedisService
{
	@Autowired
	private RedisTemplate<String, String> stringRedisTemplate;

	public void expire(String key, long timeout, TimeUnit unit)
	{
		if (unit == null)
		{
			unit = TimeUnit.SECONDS;
		}
		stringRedisTemplate.expire(key, timeout, unit);
	}

	public Set<String> keys(String pattern)
	{
		return stringRedisTemplate.keys(pattern);
	}

	public void delete(String key)
	{
		stringRedisTemplate.delete(key);
	}

	public void set(String key, String val)
	{
		stringRedisTemplate.opsForValue().set(key, val);
	}

	public void set(String key, String val, long timeout)
	{
		stringRedisTemplate.opsForValue().set(key, val, timeout, TimeUnit.SECONDS);
	}

	public void setJsonObj(String key, Object val) throws JsonProcessingException
	{
		stringRedisTemplate.opsForValue().set(key, JsonUtils.toJson(val));
	}

	public void setJsonObj(String key, Object val, long timeout) throws JsonProcessingException
	{
		stringRedisTemplate.opsForValue().set(key, JsonUtils.toJson(val), timeout, TimeUnit.SECONDS);
	}

	public String get(String key)
	{
		return stringRedisTemplate.opsForValue().get(key);
	}

	public <T> T getJson(String key, Class<T> clazz)
	{
		String val = stringRedisTemplate.opsForValue().get(key);
		return JsonUtils.fromJson(val, clazz);
	}

	public String substr(String key, Long start, Long end)
	{
		return stringRedisTemplate.opsForValue().get(key, start, end);
	}

	public String getAndSet(String key, String val)
	{
		return stringRedisTemplate.opsForValue().getAndSet(key, val);
	}

	public List<String> multiGet(Collection<String> keys)
	{
		return stringRedisTemplate.opsForValue().multiGet(keys);
	}

	public void setIfAbsent(String key, String val)
	{
		stringRedisTemplate.opsForValue().setIfAbsent(key, val);
	}

	public Long strlen(String key)
	{
		return stringRedisTemplate.opsForValue().size(key);
	}

	public void append(String key, String val)
	{
		stringRedisTemplate.opsForValue().append(key, val);
	}
}
