package com.test;


import com.service.BloomFilterService;
import com.utils.HashUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by SmallMadRabbit on 2017/7/6 0006.
 */
public class MainTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        JedisCluster jedisCluster = (JedisCluster) applicationContext.getBean("jedisCluster");
        System.out.println(jedisCluster.dbSize());
    }

    @Test
    public void main() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring/applicationContext.xml");
        Object ob = applicationContext.getBean("bloomFilterService");
        BloomFilterService bloomFilterService = (BloomFilterService) ob;
        File file = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\test1.txt");
        Scanner scanner = new Scanner(file);
        List<String> list = new ArrayList<String>();
        System.out.println("正在读取数据..");
        while(scanner.hasNext()){
            list.add(scanner.nextLine());
        }
        System.out.println("数据读取完毕，开始去重..");
        PrintWriter out = new PrintWriter(file1);
        for (String url:
             list) {
            if (bloomFilterService.add(url)){
                out.println(url);
                System.out.println(url);
            }
        }
    }

}