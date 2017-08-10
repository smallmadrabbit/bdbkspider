package com.service;

import com.model.PageInfo;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by bigjsd on 2017/7/7.
 */
@Service
public class ReceiveService {
    private static final Logger log = Logger.getLogger(ReceiveService.class);

    public void receiveMsg(String url){
        PageInfo pageInfo = new PageInfo();
        try{
            Document doc = Jsoup.connect(url).get();

            Elements name = doc.getElementsByTag("h1");
            for (Element e : name) {
                pageInfo.setName(e.text());
            }

            Elements state = doc.select(".main-content").select(".lemma-summary");
            for (Element e: state) {
                pageInfo.setState(e.text());
            }

            Elements abstracts_value = doc.select(".main-content").select(".basic-info").select(".cmn-clearfix").select(".basicInfo-item").select(".value");
            Elements abstracts_name = doc.select(".main-content").select(".basic-info").select(".cmn-clearfix").select(".basicInfo-item").select(".name");
            String[] abs = new String[abstracts_name.size()];
            for(int i=0;i<abstracts_name.size();i++){
                System.out.println();
                abs[i]=abstracts_name.text() + ":" + abstracts_value.text();
            }

            Elements imageUrl = doc.select("div.body-wrapper.feature.feature_small.starSmall > div.feature_poster > div > div > a > img");
            String src = imageUrl.attr("src");
            if (src.equals("")){
                imageUrl = doc.select("div.body-wrapper > div.content-wrapper > div > div.side-content > div.summary-pic > a > img");
                src = imageUrl.attr("src");
            }
            pageInfo.setImageUrl(src);
            log.warn(pageInfo);
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }

    /*public void receiveMsg() throws IOException {
        String url = "http://baike.baidu.com/item/%E9%83%91%E5%87%AF/2576";
        Document doc = Jsoup.connect(url).get();

        Elements name = doc.getElementsByTag("h1");
        for (Element e : name) {
            System.out.println("姓名：" + e.text());
        }
        System.out.println("--------------------------------------------------------");
        Elements state = doc.select(".desc").select(".lemma-summary");
        for (Element e: state) {
            System.out.println(e.text());
        }
        System.out.println("--------------------------------------------------------");
        Elements abstracts_value = doc.select(".main-content").select(".basic-info").select(".cmn-clearfix").select(".basicInfo-item").select(".value");
        Elements abstracts_name = doc.select(".main-content").select(".basic-info").select(".cmn-clearfix").select(".basicInfo-item").select(".name");
        for(int i=0;i<abstracts_name.size();i++){
            System.out.println(abstracts_name.get(i).text()+":"+ abstracts_value.get(i).text());
        }
        System.out.println("---------------------------------------------------------");
        Elements imageUrl = doc.select(".poster").select(".summary-pic").select("a img");
        for (Element e : imageUrl){
            System.out.println(e.attr("src"));
        }
    }*/
}
