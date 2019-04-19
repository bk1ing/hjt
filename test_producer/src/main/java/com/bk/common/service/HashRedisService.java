package com.bk.common.service;

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
		redisTemplate.expire(key, timeout, unit);
	}

	/**
	 * 获取所有匹配成功的key set集合
	 *
	 * @param pattern
	 * @return
	 */
	public Set<K> keys(String pattern)
	{
		return redisTemplate.keys(pattern);
	}

	/**
	 * 删除key
	 *
	 * @param key
	 */
	public void delete(String key)
	{
		redisTemplate.delete(key);
	}

	/**
	 * 向名称为key的hash中添加元素hashKey
	 *
	 * @param key
	 * @param hashKey
	 * @param value
	 */
	public void hSet(K key, HK hashKey, HV value)
	{
		redisTemplate.opsForHash().put(key, hashKey, value);
	}

	/**
	 * 向名称为key的hash中添加元素hashKey, 若hashKey对应value有值则不覆盖
	 *
	 * @param key
	 * @param hashKey
	 * @param value
	 */
	public void hSetIfAbsent(K key, HK hashKey, HV value)
	{
		redisTemplate.opsForHash().putIfAbsent(key, hashKey, value);
	}

	/**
	 * 返回名称为key的hash中hashKey对应的value
	 *
	 * @param key
	 * @param hashKey
	 * @return
	 */
	public HV hGet(K key, HK hashKey)
	{
		return (HV) redisTemplate.opsForHash().get(key, hashKey);
	}

	/**
	 * 向名称为key的hash中添加元素hashMap
	 *
	 * @param key
	 * @param hashMap
	 */
	public void hMSet(K key, Map<? extends HK, ? extends HV> hashMap)
	{
		redisTemplate.opsForHash().putAll(key, hashMap);
	}

	/**
	 * 返回名称为key的hash中hashKeys i对应的value 键值对
	 *
	 * @param key
	 * @param hashKeys
	 * @return
	 */
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

	/**
	 * 返回名称为key的hash中hashKeys i对应的value 集合
	 *
	 * @param key
	 * @param hashKeys
	 * @return
	 */
	public List<HV> hMGet2List(final K key, final Collection<HK> hashKeys)
	{
		return redisTemplate.opsForHash().multiGet(key, hashKeys);
	}

	/**
	 * 返回名称为key的hash中所有键对应的value 键值对
	 *
	 * @param key
	 * @return
	 */
	public Map<HK, HV> hVals(K key)
	{
		return redisTemplate.opsForHash().entries(key);
	}

	/**
	 * 返回名称为key的hash中所有键对应的value 集合
	 *
	 * @param key
	 * @return
	 */
	public List<HV> hVals2List(K key)
	{
		return redisTemplate.opsForHash().values(key);
	}

	/**
	 * 删除名称为key的hash中键为hashKey的域
	 *
	 * @param key
	 * @param hashKeys
	 */
	public void hDel(K key, HK... hashKeys)
	{
		redisTemplate.opsForHash().delete(key, hashKeys);
	}

	/**
	 * 返回名称为key的hash中元素个数
	 *
	 * @param key
	 * @return
	 */
	public Long hLen(K key)
	{
		return redisTemplate.opsForHash().size(key);
	}

	/**
	 * 名称为key的hash中是否存在键为hashKey的域
	 *
	 * @param key
	 * @param hashKey
	 * @return
	 */
	public boolean hasKey(K key, HK hashKey)
	{
		return redisTemplate.opsForHash().hasKey(key, hashKey);
	}

	/**
	 * 名称为key的hash是否存在
	 *
	 * @param key
	 * @return
	 */
	public boolean hasKey(K key)
	{
		return redisTemplate.hasKey(key);
	}

	/**
	 * 返回名称为key的hash中所有键
	 *
	 * @param key
	 * @return
	 */
	public Set<HK> hKeys(K key)
	{
		return redisTemplate.opsForHash().keys(key);
	}

	/**
	 * 将名称为key的hash中hashKey的value增加Long
	 *
	 * @param key
	 * @param hashKey
	 * @param delta   变量增量
	 * @return
	 */
	public Long hIncrBy(K key, HK hashKey, Long delta)
	{
		return redisTemplate.opsForHash().increment(key, hashKey, delta);
	}

	/**
	 * 将名称为key的hash中hashKey的value增加Double
	 *
	 * @param key
	 * @param hashKey
	 * @param stepSize
	 * @return
	 */
	public Double hIncrBy(K key, HK hashKey, Double stepSize)
	{
		return redisTemplate.opsForHash().increment(key, hashKey, stepSize);
	}

}
