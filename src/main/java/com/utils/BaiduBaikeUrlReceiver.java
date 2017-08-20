package com.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by SmallMadRabbit on 2017/7/8 0008.
 */
public class BaiduBaikeUrlReceiver {

    public static void start() {
        Thread t = new Thread(new Runnable() {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"Spring/applicationContext*.xml"});

            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
