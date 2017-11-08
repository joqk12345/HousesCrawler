package biz.yunduo.HousesCrawler.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

public class HTMLParser {

    public static void parseFromFile(String src){
        File f  = new File(src);
        try {
            Document document = Jsoup.parse(f,"utf-8");
            Elements pngs = document.select("img[src$=.jpg]");
            Elements links = document.select("a[href]"); // 具有 href 属性的链接
            Elements elements= document.select("div#tzgg1").select("ul.ul_list").select("li");
            for(Element element :elements){
                String[] strs = element.text().split(" ");
                System.out.println("项目："+strs[0]);
                System.out.println("申购日期："+ strs[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseFromString(String content){
        try {
            Document document = Jsoup.parse(content);
            Elements pngs = document.select("img[src$=.jpg]");
            Elements links = document.select("a[href]"); // 具有 href 属性的链接
            Elements elements= document.select("div#tzgg1").select("ul.ul_list").select("li");
            for(Element element :elements){
                String[] strs = element.text().split(" ");
                System.out.println("项目："+strs[0]);
                System.out.println("申购日期："+ strs[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
