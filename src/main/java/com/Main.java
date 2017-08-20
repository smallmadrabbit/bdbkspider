package com;

import com.utils.BaiduBaikeUrlReceiver;
import com.utils.BaiduBaikeUrlSender;

import java.util.Scanner;

/**
 * Created by SmallMadRabbit on 2017/7/8 0008.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //输出开头
        printTitle();
        //输出菜单
        printMenu();
    }

    private static void printTitle(){
        System.out.println("                          __                                 ,             g/     ");
        System.out.println("  00M0Mg          0f      ]0           00M0N,  ##   0F   pM@0M,gggg        0      ");
        System.out.println("  01  ]0          `       ]0           0   40  ## _0F    &]14 ]5# B    0MMM0MMM0f ");
        System.out.println("  01  j0  +M00g   0f  gM0qJ0  ##   01  0   #F  ##_0X     &]1] ] 4 #    #   0   4f ");
        System.out.println("  0000&_      #&  0f ]0'  #0  ##   01  0000Q   ##00      !]1] ]M0M0    #   0   4f ");
        System.out.println("  01  \"0p _g0M0#  0f ##   ]0  ##   01  0   M0  #0 #&    ]I]1]f]   `    0M@@0M@@01 ");
        System.out.println("  01   0& 0f  ##  0f ##   ]0  ##   01  0    0f ##  0&   jf]1 &4Lggg9   ~   0   g  ");
        System.out.println("  0L,pN0  0&,g0#  0f  0&,gM0  ]0g,#01  0g,p0#  ##   0&  0 ]1 #g_``        _0__,B& ");
        System.out.println("  ~~~~~    ~~^~\"  ~'   ~~^ ~   ~~~ \"'  ~~~~`   \"^   ^~'\"! +!  ~M000f  #0MM@M~~~~#X");
        System.out.println("--------------------------------------------------------------------------------------");
    }

    private static void printMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("数字1 : 爬虫URL提供端");
        System.out.println("数字2 : 爬虫URL消费端");
        System.out.print("请输入选择 :");
        int number = scanner.nextInt();
        switch (number){
            case 1:runSender();break;
            case 2:runReceiver();break;
        }
    }
    private static void runSender(){
        System.out.println("请输入开始节点 :");
        int start = scanner.nextInt();
        System.out.println("请输入结束节点 :");
        int end = scanner.nextInt();

        BaiduBaikeUrlSender baiduBaikeUrlSender = new BaiduBaikeUrlSender(start,end,3*60*1000,300,4);
        baiduBaikeUrlSender.start();
    }
    private static void runReceiver(){
        BaiduBaikeUrlReceiver.start();
    }
}
