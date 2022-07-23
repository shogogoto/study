package com.example.api;

import com.example.datasorce.DbMapper;
import com.example.datasorce.Rss;
import com.example.datasorce.RssMapper;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Hello {
    @Autowired
    private DbMapper dbMapper;
    @Autowired
    public RssMapper rssMapper;

    @RequestMapping(value = "/hello", method= RequestMethod.GET)
    public Map hello(){
        Map<String, Object> res = new HashMap<>();
        res.put("response", "hello");
        return res;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map list(){
        Map<String, Object> res = new HashMap<>();
        res.put("response", dbMapper.select().stream().map(v -> v.event_date_time).toList());
        return res;
    }

    @RequestMapping(value = "/rss", method = RequestMethod.GET)
    public Map rss(){
        String urlStr = "https://b.hatena.ne.jp/hotentry.rss";
        Map<String, Object> res = new HashMap<>();
        try {
            URL url = new URL(urlStr);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(url));
            System.out.println(feed.getTitle());
            for (Object obj : feed.getEntries()) {
                SyndEntry entry = (SyndEntry) obj;
                Rss rss = Rss.from(entry);
                rssMapper.insert(rss);
            }
            res.put("response", "ok");
            return res;
        }
        catch(MalformedURLException e){
            e.printStackTrace();
        } catch (FeedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        res.put("response", "ng");
        return res;
    }

}
