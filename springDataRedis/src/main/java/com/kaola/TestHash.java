package com.kaola;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext-redis.xml")
public class TestHash {

    @Autowired
    private RedisTemplate  redisTemplate;

    @Test
    public void setValue(){
        redisTemplate.boundHashOps("h1").put("a1","孙悟空");
        redisTemplate.boundHashOps("h1").put("a2","二师兄");
        redisTemplate.boundHashOps("h1").put("a3","沙师弟");
    }

    @Test
    public void getValue(){
        List h1 = redisTemplate.boundHashOps("h2").values();
        System.out.println(h1);

    }

    @Test
    public  void getValueOne(){

    }

    @Test
    public void delteValue(){
        redisTemplate.delete("h1");
    }

}
