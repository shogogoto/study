package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.net.URL;

@AllArgsConstructor
public class FeedUrl {
    @Getter
    @Nullable
    private URL value;

//    public static Optional<FeedUrl> create(String url){
//        URL validUrl = null;
//        try {
//            validUrl = new URL(url);
//        } catch(MalformedURLException e){
//            e.printStackTrace();
//        }
//        return Optional.of(new FeedUrl(validUrl));
//    }
}
