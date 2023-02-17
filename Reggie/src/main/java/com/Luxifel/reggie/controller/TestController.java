package com.Luxifel.reggie.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestController {
    @Test
    public void jedisTest(){
        Jedis jedis=new Jedis("192.168.221.128",6379);
        jedis.auth("123456");
        /*****************String示例*****************/
        //设置字符串数据
        jedis.set("word","helloWorld");
        //读取字符串数据
        System.out.println(jedis.get("word"));
        //删除数据
        jedis.del("word");

        /*****************List示例*****************/
        jedis.lpush("list","google");
        jedis.lpush("list","aLi");
        jedis.rpush("list","Mi");

        List<String> stringList = jedis.lrange("list",0l,-1l);
        for(String str:stringList){
            System.out.println(str);
        }

        /*****************Hash示例*****************/
        HashMap<String,String> map = new HashMap<>();
        map.put("name","tom");
        map.put("age","81");
        jedis.hmset("man",map);
        System.out.println(jedis.hmget("man","name"));
        System.out.println(jedis.hgetAll("man"));
        System.out.println("获取所有字段:"+jedis.hkeys("man"));
        System.out.println("获取字段数量："+jedis.hlen("man"));
        System.out.println("判断age字段是否存在:"+jedis.hexists("man","age"));

        /*****************Set示例*****************/
        jedis.sadd("set1","1");
        jedis.sadd("set1","2");
        jedis.sadd("set1","1");
        jedis.sadd("set2","1");
        jedis.sadd("set2","4");
        System.out.println("获取集合的成员数"+jedis.scard("set1"));
        System.out.println("获取集合中的成员"+jedis.smembers("set2"));
        System.out.println("判断集合是否包含指定成员"+jedis.sismember("set1","2"));
        System.out.println("获取多个集合的交集"+jedis.sinter("set1","set2"));
        System.out.println("获取多个集合并集"+jedis.sunion("set1","set2"));
        System.out.println("返回第一个集合与其他集合之间的差异"+jedis.sdiff("set1","set2"));

        /*****************sorted Set示例*****************/
        jedis.zadd("set3",1,"a");
        jedis.zadd("set3",3,"b");
        System.out.println("获取有序集合的成员数"+jedis.zcard("set3"));
        System.out.println("获取元素对应的索引"+jedis.zrank("set3","b"));
        System.out.println("获取有序集合指定范围的元素"+jedis.zrange("set3",0,-1));
        System.out.println("移除集合中的一个元素或多个元素"+jedis.zrem("set3","a"));
        jedis.zadd("set3",3,"c");
        System.out.println("获取有序集合指定范围的元素"+jedis.zrange("set3",0,-1));
        jedis.zadd("set3",5,"b");
        System.out.println("获取有序集合指定范围的元素"+jedis.zrange("set3",0,-1));

        Set<String> Allkey = jedis.keys("*");
        System.out.println(Allkey);

        jedis.close();
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void springDataJedisTest(){
        redisTemplate.opsForValue().set("city12313","shanghai");

        String value = (String) redisTemplate.opsForValue().get("city");
        System.out.println(value);

        redisTemplate.opsForValue().set("save","save?",10l, TimeUnit.SECONDS);

    }
}
