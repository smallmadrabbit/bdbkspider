package com.main;

import com.utils.BaiduBaikeUrlGetter;

import java.io.FileNotFoundException;

/**
 * Created by SmallMadRabbit on 2017/7/6 0006.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BaiduBaikeUrlGetter baiduBaikeUrlGetter = new BaiduBaikeUrlGetter(0,5000,3*60*1000,200,4);
        baiduBaikeUrlGetter.start();
    }
}
