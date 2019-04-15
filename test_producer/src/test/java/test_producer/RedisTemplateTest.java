package test_producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * redisTemplate测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest
{

	@Autowired
	// private StringRedisTemplate redisTemplate;
	private RedisTemplate<String, String> redisTemplate;
	// private RedisTemplate<Object, Object> redisTemplate;

	@Test
	public void testRedisTemplate()
	{
		redisTemplate.opsForValue().set("test2", "ddd", 50, TimeUnit.SECONDS);
		System.out.println(redisTemplate.opsForValue().get("test2"));
	}
}
