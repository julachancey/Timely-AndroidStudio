package com.example.dig4634_timely;

import java.time.LocalTime;
import java.util.ArrayList;

class HourEvent
{
    LocalTime time;
    ArrayList<com.example.dig4634_timely.Event> events;

    public HourEvent(LocalTime time, ArrayList<com.example.dig4634_timely.Event> events)
    {
        this.time = time;
        this.events = events;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

    public ArrayList<com.example.dig4634_timely.Event> getEvents()
    {
        return events;
    }

    public void setEvents(ArrayList<com.example.dig4634_timely.Event> events)
    {
        this.events = events;
    }
}