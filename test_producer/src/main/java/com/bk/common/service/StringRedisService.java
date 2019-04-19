package com.bk.common.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.bk.common.tools.JsonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

public class StringRedisService
{
	@Autowired
	private RedisTemplate<String, String> stringRedisTemplate;

	/**
	 * 设置有效期
	 *
	 * @param key
	 * @param timeout
	 * @param unit
	 */
	public void expire(String key, long timeout, TimeUnit unit)
	{
		if (unit == null)
		{
			unit = TimeUnit.SECONDS;
		}
		stringRedisTemplate.expire(key, timeout, unit);
	}

	/**
	 * 获取所有匹配成功的key set集合
	 *
	 * @param pattern
	 * @return
	 */
	public Set<String> keys(String pattern)
	{
		return stringRedisTemplate.keys(pattern);
	}

	/**
	 * 删除key
	 *
	 * @param key
	 */
	public void delete(String key)
	{
		stringRedisTemplate.delete(key);
	}

	/**
	 * 插入字符串key value
	 *
	 * @param key
	 * @param val
	 */
	public void set(String key, String val)
	{
		stringRedisTemplate.opsForValue().set(key, val);
	}

	/**
	 * 插入key, 并设置有效期(单位s秒)
	 *
	 * @param key
	 * @param val
	 * @param timeout
	 */
	public void set(String key, String val, long timeout)
	{
		stringRedisTemplate.opsForValue().set(key, val, timeout, TimeUnit.SECONDS);
	}

	/**
	 * 插入json格式的对象
	 *
	 * @param key
	 * @param val
	 */
	public void setJsonObj(String key, Object val) throws JsonProcessingException
	{
		stringRedisTemplate.opsForValue().set(key, JsonUtils.toJson(val));
	}

	/**
	 * 插入json格式的对象, 并设置有效期(单位s秒)
	 *
	 * @param key
	 * @param val
	 * @param timeout
	 */
	public void setJsonObj(String key, Object val, long timeout) throws JsonProcessingException
	{
		stringRedisTemplate.opsForValue().set(key, JsonUtils.toJson(val), timeout, TimeUnit.SECONDS);
	}

	/**
	 * 获取字符串, by key
	 *
	 * @param key
	 * @return
	 */
	public String get(String key)
	{
		return stringRedisTemplate.opsForValue().get(key);
	}

	/**
	 * 获取json字符串, 并转换为参数指定的对象
	 *
	 * @param key
	 * @param clazz
	 * @param       <T>
	 */
	public <T> T getJson(String key, Class<T> clazz)
	{
		String val = stringRedisTemplate.opsForValue().get(key);
		return JsonUtils.fromJson(val, clazz);
	}

	/**
	 * 获取key 并且截取字符串
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public String substr(String key, Long start, Long end)
	{
		return stringRedisTemplate.opsForValue().get(key, start, end);
	}

	/**
	 * 获取老的值并设置新的值
	 * 
	 * @param key
	 * @param val
	 * @return
	 */
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
