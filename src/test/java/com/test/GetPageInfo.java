package com.test;

import com.model.PageInfo;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by bigjsd on 2017/7/7.
 */
public class GetPageInfo {
    private static final Logger log = Logger.getLogger(GetPageInfo.class);

    @Test
    public void receiveMsg(String url){

        PageInfo pageInfo = new PageInfo();
        try{
            Document doc = Jsoup.connect(url).get();

            Elements state = doc.select(".main-content").select(".lemma-summary");
            for (Element e: state) {
                pageInfo.setState(e.text());
            }

            Elements abstracts_value = doc.select(".main-content").select(".basic-info").select(".cmn-clearfix").select(".basicInfo-item").select(".value");
            Elements abstracts_name = doc.select(".main-content").select(".basic-info").select(".cmn-clearfix").select(".basicInfo-item").select(".name");
            String[] abs = new String[abstracts_name.size()];
            for(int i=0;i<abstracts_name.size();i++){
                abs[i]=abstracts_name.text() + ":" + abstracts_value.text();
            }

            Elements imageUrl = doc.select(".side-content").select(".summary-pic").select("a img");
            for (Element e : imageUrl){
                pageInfo.setImageUrl(e.text());
            }
            log.debug(pageInfo);
        }catch(Exception e){
            log.error(e.getMessage());
        }
    }

}
