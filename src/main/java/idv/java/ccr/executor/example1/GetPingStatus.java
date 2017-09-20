package idv.java.ccr.executor.example1;

import java.util.Arrays;

/**
 * @author Carl Lu
 */
public class GetPingStatus {

    public static void main(String args[]) throws Exception {
        String[] hostList = {"http://crunchify.com", "http://yahoo.com", "http://www.ebay.com", "http://google.com",
                "http://www.example.co", "https://paypal.com", "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/", "http://wordpress.com/", "http://wordpress.org/",
                "http://example.com/", "http://sjsu.edu/", "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/", "http://en.wikipedia.org/wiki/Main_Page", "https://martinfowler.com/",
                "http://cn.nytimes.com/zh-hant/", "https://www.youtube.com", "https://www.linkedin.com/uas/login",
                "https://leetcode.com/problemset/algorithms/", "http://www.devstore.cn/",
                "https://css.fetc.net.tw/CS/CS06010eTagGoLogin/Login", "https://www.windytv.com/", "https://c.8891.com.tw/",
                "http://rate.bot.com.tw/xrt?Lang=zh-TW"};

        long start = System.currentTimeMillis();
        Arrays.stream(hostList).forEach(url -> {
            new UrlDetector(url).run();
        });
        long end = System.currentTimeMillis();
        System.out.println("Total cost time: " + (end - start) + " msecs.");
    }

}
