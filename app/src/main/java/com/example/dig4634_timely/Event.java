package com.example.dig4634_timely;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Event
{
    public static ArrayList<com.example.dig4634_timely.Event> eventsList = new ArrayList<>();

    public static ArrayList<com.example.dig4634_timely.Event> eventsForDate(LocalDate date)
    {
        ArrayList<com.example.dig4634_timely.Event> events = new ArrayList<>();

        for(com.example.dig4634_timely.Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }

    public static ArrayList<com.example.dig4634_timely.Event> eventsForDateAndTime(LocalDate date, LocalTime time)
    {
        ArrayList<com.example.dig4634_timely.Event> events = new ArrayList<>();

        for(com.example.dig4634_timely.Event event : eventsList)
        {
            int eventHour = event.time.getHour();
            int cellHour = time.getHour();
            if(event.getDate().equals(date) && eventHour == cellHour)
                events.add(event);
        }

        return events;
    }


    private String name;
    private LocalDate date;
    private LocalTime time;
    private Double lat;
    private Double lon;

    public Event(String name, LocalDate date, LocalTime time, Double lat, Double lon)
    {
        this.name = name;
        this.date = date;
        this.time = time;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public Double getLon()
    {
        return lon;
    }

    public Double getLat()
    {
        return lat;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }
}