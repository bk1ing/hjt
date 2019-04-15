package test_producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
 
/**
 * SpringBoot缓存注解测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisCacheTest {
 
    @Autowired
    private StringRedisTemplate template;
 
    @Autowired
    private com.bk.test.producer.service.UserService userService;
 
 
    @Test
    public void getUser() {
        for (int i = 0; i < 5; i++) {
            com.bk.test.producer.entity.User user = userService.getUser(String.valueOf(i));
            System.out.println(user);
        }
    }
 
    @Test
    public void deleteUser() {
        for (int i = 0; i < 5; i++) {
            userService.deleteUser(String.valueOf(i));
        }
    }
}