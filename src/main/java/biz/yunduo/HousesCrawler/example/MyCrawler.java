package biz.yunduo.HousesCrawler.example;

import biz.yunduo.HousesCrawler.util.HTMLParser;
import com.xiaoleilu.hutool.io.file.FileWriter;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Set;

public class MyCrawler extends WebCrawler {
   // private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp4|zip|gz))$");
    private String visterUrl = "www.sina.com.cn";
    private String visterUrl1 = "http://news.sina.com.cn/";
    private String visterUrl2 = "http://www.bjjs.gov.cn/bjjs/xxgk/ztzl/gycqzf/index.shtml";


    private Logger logger = LoggerFactory.getLogger(MyCrawler.class);
    /**
     * This method receives two parameters. The first parameter is the page
     * in which we have discovered this new url and the second parameter is
     * the new url. You should implement this function to specify whether
     * the given url should be crawled or not (based on your crawling logic).
     * In this example, we are instructing the crawler to ignore urls that
     * have css, js, git, ... extensions and to only accept urls that start
     * with "http://www.ics.uci.edu/". In this case, we didn't need the
     * referringPage parameter to make the decision.
     */
    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
//        return !FILTERS.matcher(href).matches()&& href.startsWith("http://www.sina.com.cn/");
        logger.debug("新访问这个网页,网页的URL地址为:"+href);
        return  href.startsWith(visterUrl2);
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            HTMLParser.parseFromString(html);

//            logger.debug("仅仅访问这个网页,网页的HTML内容为:"+html);
//            FileWriter f = FileWriter.create(new File("D://data/test/test.txt"));
//            f.append(html);

            System.out.println("Text length: " + text.length());
            System.out.println("Html length: " + html.length());
            System.out.println("Number of outgoing links: " + links.size());
        }
    }
}