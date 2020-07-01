package com.jeomo.crawler.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeomo.crawler.domain.School;
import com.jeomo.crawler.mapper.SchoolMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qbt
 * @Date: 2020/6/27 9:47
 * @Version 1.0
 */
@Service
public class CrawlerService extends ServiceImpl<SchoolMapper, School> {

    public void paqu(int begin, int end) throws IOException {
        int no = 1;
        String url = "https://www.ruyile.com/xuexiao/?p=";
        List<School> schools = new ArrayList<>(40000);
        for(int p = begin; p < end; p++) {
            Document document = Jsoup.parse(new URL(url + p), 300000);
            Elements skEles = document.getElementsByClass("sk");
            int i = 0;
            for(Element sk : skEles){
                String s = sk.html();
                String phone = getPhone(s);
                String address = getAddress(s);
                String name = getName(sk);
                School sc = School.builder().address(address).name(name).phone(phone).build();
                schools.add(sc);
            }
            System.out.println(no++);
        }
        saveBatch(schools, 1000);
    }

    static String getName(Element sk) {
        Elements sknameEles = sk.getElementsByTag("h4");
        if(sknameEles != null && sknameEles.size() > 0) {
            Elements skn = sknameEles.get(0).getElementsByTag("a");
            if(skn != null) {
                String scName = skn.html();
                return scName;
            }
        }
        return "";
    }

    static String getPhone(String s) {
        if(s.indexOf("电话：") != -1) {
            s = s.substring(s.indexOf("电话："));
            s = s.substring(s.indexOf("：") + 1 , s.indexOf("<br>") - 1);
            return s;
        }
        return "";
    }

    static String getAddress(String s) {
        if(s.indexOf("地址：") != -1) {
            s = s.substring(s.indexOf("地址："));
            s = s.substring(s.indexOf("：") + 1 , s.indexOf("<div") - 1);
            return s;
        }
        return "";
    }

}
