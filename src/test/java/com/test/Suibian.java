package com.test;

import com.utils.BaiduBaikeUrlGetter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by bigjsd on 2017/7/8.
 */
public class Suibian {
    @Test
    public void aa() {
        Thread t = new Thread(new Runnable() {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"Spring/applicationContext*.xml"});
            public void run() {
                while (true){

                }
            }
        });
        t.start();
        while (true){}
    }
    @Test
    public void bb(){
        BaiduBaikeUrlGetter baiduBaikeUrlGetter = new BaiduBaikeUrlGetter(1,5000,3*60*1000,200,4);
        baiduBaikeUrlGetter.start();
    }
}
