package com.bo;

import com.bo.domain.User;
import com.bo.mapper.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@RunWith (SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class RedisTest {
@Autowired
private UserRepository userRepository;
@Autowired
    private RedisTemplate<String,String> redisTemplate;
@Test
    public void test() throws JsonProcessingException {

    String s = redisTemplate.boundValueOps ( "user.findAll" ).get ();
    if (s==null){
        List<User> all = userRepository.findAll ();
ObjectMapper objectMapper=new ObjectMapper ( );
        s = objectMapper.writeValueAsString ( all );
        redisTemplate.boundValueOps("user.findAll").set(s);

        System.out.println("=======从数据库中获得user的数据======");

    }else{
        System.out.println("=======从redis缓存中获得user的数据======");
    }
    //4、将数据在控制台打印
    System.out.println(s);
    }

    }


