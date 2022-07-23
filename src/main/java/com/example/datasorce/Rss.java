package com.example.datasorce;


import com.rometools.rome.feed.synd.SyndEntry;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Rss {
    public int id;
    public String title;
    public String link;
    public String description;
    public LocalDateTime event_date_time;

    public static Rss from(SyndEntry entry){
        Rss rss = new Rss();
        rss.title = entry.getTitle();
        rss.link = entry.getLink();
        rss.description = entry.getDescription().getValue();
        rss.event_date_time = LocalDateTime.now();
        return rss;
    }
}
