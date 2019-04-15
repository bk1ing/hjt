package test_producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bk.common.service.RedisService;
 
/**
 * RedisService测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {
    @Autowired
    RedisService redisService;
 
    @Test
    public void setTest()  {
        redisService.setValue("key","hello");
    }
 
    @Test
    public void getTest()  {
        System.out.println("getTest:"+ redisService.getValue("key"));
    }
 
}
