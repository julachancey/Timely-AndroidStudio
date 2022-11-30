
package com.example.dig4634_timely;
import static com.example.dig4634_timely.CalendarUtils.selectedDate;

import android.os.Bundle;
import java.time.LocalDate;
import java.time.LocalTime;

import androidx.appcompat.app.AppCompatActivity;
import com.google.api.services.calendar.model.Event;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

    public class CalendarQuickstart extends AppCompatActivity
    {

        private TextView monthDayText;
        private TextView dayOfWeekTV;
        private ListView hourListView;

        public static ArrayList<com.example.dig4634_timely.Event> eventsList = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_calendar);
            initWidgets();
        }

        private void initWidgets()
        {
            monthDayText = findViewById(R.id.monthDayText);
            dayOfWeekTV = findViewById(R.id.dayOfWeekTV);
            hourListView = findViewById(R.id.hourListView);
        }

        @Override
        protected void onResume()
        {
            super.onResume();
            setDayView();
        }

        private void setDayView()
        {
            monthDayText.setText(CalendarUtils.monthDayFromDate(selectedDate));
            String dayOfWeek = selectedDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
            dayOfWeekTV.setText(dayOfWeek);
            setHourAdapter();
        }

        private void setHourAdapter()
        {
            HourAdapter hourAdapter = new HourAdapter(getApplicationContext(), hourEventList());
            hourListView.setAdapter(hourAdapter);
        }

        private ArrayList<HourEvent> hourEventList()
        {
            ArrayList<HourEvent> list = new ArrayList<>();

            for(int hour = 0; hour < 24; hour++)
            {
                LocalTime time = LocalTime.of(hour, 0);
                ArrayList<com.example.dig4634_timely.Event> events = com.example.dig4634_timely.Event.eventsForDateAndTime(selectedDate, time);
                HourEvent hourEvent = new HourEvent(time, events);
                list.add(hourEvent);
            }

            return list;
        }

        public void previousDayAction(View view)
        {
            selectedDate = selectedDate.minusDays(1);
            setDayView();
        }

        public void nextDayAction(View view)
        {
            selectedDate = selectedDate.plusDays(1);
            setDayView();
        }

        public void newEventAction(View view)
        {
            startActivity(new Intent(this, EventEditActivity.class));
        }
    }