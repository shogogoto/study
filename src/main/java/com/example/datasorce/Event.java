package com.example.datasorce;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Event {
    public int id;

    public LocalDateTime event_date_time;
}