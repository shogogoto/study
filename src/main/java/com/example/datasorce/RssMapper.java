package com.example.datasorce;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface RssMapper {

    @Select("SELECT * FROM rss ORDER BY id")
    List<Event> select();

    @Insert("INSERT INTO rss (" +
            "   title, " +
            "   link, " +
            "   description," +
            "   event_date_time" +
            ") " +
            "VALUES (" +
            "   #{title}," +
            "   #{link}," +
            "   #{description}," +
            "   #{event_date_time}" +
            ");")
    void insert(Rss rss);
}