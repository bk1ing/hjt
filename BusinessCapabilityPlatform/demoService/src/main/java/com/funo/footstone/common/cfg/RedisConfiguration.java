package com.funo.footstone.common.cfg;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class RedisConfiguration extends CachingConfigurerSupport
{
	@Bean
	public KeyGenerator keyGenerator()
	{
		return new KeyGenerator()
		{
			@Override
			public Object generate(Object target, Method method, Object... params)
			{
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append("#" + method.getName());
				for (Object obj : params)
				{
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

	@Bean
	public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate)
	{
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
				.serializeKeysWith(
						RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getKeySerializer())) // key序列化方式
				.serializeValuesWith(
						RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer())) // value序列化方式
				.disableCachingNullValues()
				.entryTtl(Duration.ofSeconds(60));
		Set<String> cacheNames = new HashSet<>();
		cacheNames.add("user");
		Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
		configMap.put("user", redisCacheConfiguration.entryTtl(Duration.ofSeconds(120)));

		RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisTemplate.getConnectionFactory())
				.cacheDefaults(redisCacheConfiguration).transactionAware().initialCacheNames(cacheNames) // 注意这两句的调用顺序，一定要先调用该方法设置初始化的缓存名，再初始化相关的配置
				.withInitialCacheConfigurations(configMap).build();
		return redisCacheManager;
	}

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException
	{
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		RedisSerializer stringSerializer = new StringRedisSerializer();

		redisTemplate.setKeySerializer(stringSerializer);
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setHashKeySerializer(stringSerializer);
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
	
	@Bean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory)
			throws UnknownHostException
	{
		StringRedisTemplate template = new StringRedisTemplate();
		template.setConnectionFactory(redisConnectionFactory);
		return template;
	}

}