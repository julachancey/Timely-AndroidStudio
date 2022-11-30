package com.example.dig4634_timely;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import android.os.Bundle;

import java.util.ArrayList;
import android.Manifest;
import android.widget.TextView;

public class Notification extends AppCompatActivity implements View.OnClickListener {
    final int PERMISSION_REQUEST_CODE = 0;
    final int metersPerMinute = 84;
    private TextView eventName, timeToGetThere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        boolean permissionGranted =
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED;
        if (permissionGranted) {
            startGPS();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);

        }

        initWidgets();

    }

    private void initWidgets()
    {
        eventName = findViewById(R.id.eventName);
        timeToGetThere = findViewById(R.id.timeToGetThere);
    }

    public void startGPS() {

        boolean permissionGranted =
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED;

        if (permissionGranted) {
            LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            //manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500L, 1F, (LocationListener) this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {


        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {

            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                finish();
            } else {
                startGPS();
            }

        }
    }

    @Override
    public void onClick(View view) {


    }


    public void onLocationChanged(Location location) {
        Log.d("Example", "New location received. Long:" + location.getLongitude() + " Lat:" + location.getLatitude());

        ArrayList<com.example.dig4634_timely.Event> eventsList = com.example.dig4634_timely.Event.eventsList;
        for (com.example.dig4634_timely.Event event : eventsList) {

            Location dest =new Location(LocationManager.GPS_PROVIDER);
            dest.setLatitude(event.getLat());
            dest.setLongitude(event.getLon());

            float distanceInMeters = location.distanceTo(dest);
            int timeToDestination = (int) (distanceInMeters / metersPerMinute);

            eventName.setText("Event: " + event.getName());
            timeToGetThere.setText("Time to get there: " + timeToDestination + " minutes");

        }
    }
}