package com.service;

import com.utils.HashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * Created by SmallMadRabbit on 2017/7/7 0007.
 */
@Service
public class BloomFilterService {
    @Autowired
    private Jedis jedis;
    private static final int MAX_SIZE = 500000000;
    private final String BLOOM_NAME = "BLOOM_BITS";

    public boolean add(String str){
        if (!jedis.exists(BLOOM_NAME)){
            jedis.setbit(BLOOM_NAME,MAX_SIZE,false);
        }
        int[] hashs = toHashs(str);
        if (isExist(hashs)){
            //判断在集合中是否存在
            return false;
        }else {
            //如果不存在，将对应的hash位置为1
            for (int hash:
                 hashs) {
                jedis.setbit(BLOOM_NAME,hash,true);
            }
            return true;
        }
    }

    
    public boolean isExist(int[] hashs){
        boolean flag = true;
        for (int hash:hashs) {
            flag = flag && jedis.getbit(BLOOM_NAME, hash);
            if (!flag){
                break;
            }
        }
        return flag;
    }


    public int[] toHashs(String url){
        int[]  hashs= new int[7];
        hashs[0] = Math.abs(HashUtils.additiveHash(url, 47) % MAX_SIZE);
        hashs[1] = Math.abs(HashUtils.rotatingHash(url, 47) % MAX_SIZE);
        hashs[2] = Math.abs(HashUtils.oneByOneHash(url)) % MAX_SIZE;
        hashs[3] = Math.abs(HashUtils.bernstein(url)) % MAX_SIZE;
        hashs[4] = Math.abs(HashUtils.FNVHash(url.getBytes()) % MAX_SIZE);
        hashs[5] = Math.abs(HashUtils.RSHash(url)) % MAX_SIZE;
        hashs[6] = Math.abs(HashUtils.JSHash(url)) % MAX_SIZE;
/*        hashs[7] = Math.abs(HashUtils.PJWHash(url)) % MAX_SIZE;
        hashs[8] = Math.abs(HashUtils.ELFHash(url)) % MAX_SIZE;
        hashs[9] = Math.abs(HashUtils.BKDRHash(url)) % MAX_SIZE;
        hashs[10] = Math.abs(HashUtils.SDBMHash(url)) % MAX_SIZE;
        hashs[11] = Math.abs(HashUtils.DJBHash(url)) % MAX_SIZE;
        hashs[12] = Math.abs(HashUtils.DEKHash(url)) % MAX_SIZE;
        hashs[13] = Math.abs(HashUtils.APHash(url)) % MAX_SIZE;
        hashs[14] = Math.abs(HashUtils.java(url)) % MAX_SIZE;*/
        return hashs;
    }

}
