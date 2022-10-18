package com.example.dig4634_timely;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import android.os.Bundle;

public class Notification extends AppCompatActivity implements View.OnClickListener {
    MaterialButton calendar, map, notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    @Override
    public void onClick(View view) {

    }
}