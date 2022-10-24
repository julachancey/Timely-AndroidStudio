package com.example.dig4634_timely;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.view.View;

        import com.google.android.material.button.MaterialButton;
        import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MaterialButton calendar, map, notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignId(calendar,R.id.calendar);
        assignId(map,R.id.map);
        assignId(notification,R.id.notification);
    }

    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("calendar")) {
            Intent myIntent=new Intent(getBaseContext(), CalendarQuickstart.class);
            startActivity(myIntent);
            return;
        }
        if (buttonText.equals("map")) {
            Intent myIntent=new Intent(getBaseContext(), MapsActivity.class);
            startActivity(myIntent);
            return;
        }
        if (buttonText.equals("notification")) {
            Intent myIntent=new Intent(getBaseContext(), Notification.class);
            startActivity(myIntent);
            return;
        }
    }
}