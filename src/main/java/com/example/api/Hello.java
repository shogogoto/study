package com.example.api;

import com.example.datasorce.DbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Hello {
    @Autowired
    private DbMapper dbMapper;

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

}
