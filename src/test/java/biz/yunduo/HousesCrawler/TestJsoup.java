package biz.yunduo.HousesCrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;

public class TestJsoup {

    public static void main(String[] args) throws FileNotFoundException {
        File f  = new File("D://data/test/test.txt");
        try {
            Document document = Jsoup.parse(f,"utf-8");
            Elements pngs = document.select("img[src$=.jpg]");
            Elements links = document.select("a[href]"); // 具有 href 属性的链接
            Elements elements= document.select("div#tzgg1").select("ul.ul_list").select("li");
            for(Element element :elements){
//                System.out.println(elements.html());
//                System.out.println(element.getElementsByAttribute("title"));
               // System.out.println(element.html());
                String[] strs = element.text().split(" ");
                System.out.println("项目："+strs[0]);
                System.out.println("申购日期："+ strs[1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(html);
    }
}
