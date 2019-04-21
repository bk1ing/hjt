package com.funo.footstone.common.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class HashRedisService<K, HK, HV>
{

	@Autowired
	private RedisTemplate redisTemplate;

	public void expire(String key, long timeout, TimeUnit unit)
	{
		if (unit == null)
		{
			unit = TimeUnit.SECONDS;
		}
		redisTemplate.expire(key, timeout, unit);
	}

	public Set<K> keys(String pattern)
	{
		return redisTemplate.keys(pattern);
	}

	public void delete(String key)
	{
		redisTemplate.delete(key);
	}

	public void hSet(K key, HK hashKey, HV value)
	{
		redisTemplate.opsForHash().put(key, hashKey, value);
	}
	
	public void hSetIfAbsent(K key, HK hashKey, HV value)
	{
		redisTemplate.opsForHash().putIfAbsent(key, hashKey, value);
	}

	public HV hGet(K key, HK hashKey)
	{
		return (HV) redisTemplate.opsForHash().get(key, hashKey);
	}

	public void hMSet(K key, Map<? extends HK, ? extends HV> hashMap)
	{
		redisTemplate.opsForHash().putAll(key, hashMap);
	}

	public Map<HK, HV> hMGet(K key, Collection<HK> hashKeys)
	{
		Map<HK, HV> hashMap = new HashMap<HK, HV>();
		List<HV> valueList = redisTemplate.opsForHash().multiGet(key, hashKeys);

		int i = 0;
		for (HK hashKey : hashKeys)
		{
			hashMap.put(hashKey, valueList.get(i));
			i++;
		}
		return hashMap;
	}

	public List<HV> hMGet2List(final K key, final Collection<HK> hashKeys)
	{
		return redisTemplate.opsForHash().multiGet(key, hashKeys);
	}

	public Map<HK, HV> hVals(K key)
	{
		return redisTemplate.opsForHash().entries(key);
	}

	public List<HV> hVals2List(K key)
	{
		return redisTemplate.opsForHash().values(key);
	}

	public void hDel(K key, HK... hashKeys)
	{
		redisTemplate.opsForHash().delete(key, hashKeys);
	}

	public Long hLen(K key)
	{
		return redisTemplate.opsForHash().size(key);
	}

	public boolean hasKey(K key, HK hashKey)
	{
		return redisTemplate.opsForHash().hasKey(key, hashKey);
	}

	public boolean hasKey(K key)
	{
		return redisTemplate.hasKey(key);
	}

	public Set<HK> hKeys(K key)
	{
		return redisTemplate.opsForHash().keys(key);
	}

	public Long hIncrBy(K key, HK hashKey, Long delta)
	{
		return redisTemplate.opsForHash().increment(key, hashKey, delta);
	}

	public Double hIncrBy(K key, HK hashKey, Double stepSize)
	{
		return redisTemplate.opsForHash().increment(key, hashKey, stepSize);
	}

}
