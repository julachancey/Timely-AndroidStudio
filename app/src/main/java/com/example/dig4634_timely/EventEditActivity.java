package com.example.dig4634_timely;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventEditActivity extends AppCompatActivity
{
    private EditText eventNameET;
    private EditText eventTimeET, eventLatET, eventLonET;
    private TextView eventDateTV, eventTimeTV;

    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeET = findViewById(R.id.eventTimeET);
        eventLatET = findViewById(R.id.latET);
        eventLonET = findViewById(R.id.lonET);
    }

    public void saveEventAction(View view)
    {
        String eventName = eventNameET.getText().toString();
        Double eventLat = Double.parseDouble(eventLatET.getText().toString());
        Double eventLon = Double.parseDouble(eventLonET.getText().toString());
        LocalTime eventTime = LocalTime.parse(eventTimeET.getText());
        com.example.dig4634_timely.Event newEvent = new com.example.dig4634_timely.Event(eventName, CalendarUtils.selectedDate, eventTime, eventLat, eventLon);
        com.example.dig4634_timely.Event.eventsList.add(newEvent);
        finish();
    }
}