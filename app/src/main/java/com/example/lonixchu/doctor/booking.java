package com.example.lonixchu.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;

public class booking extends AppCompatActivity {
    public long date = 0;
    public long time = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        final Button btnA = (Button) findViewById(R.id.buttonA);
        final CalendarView cv = (CalendarView) findViewById(R.id.calendarView2);
        final TimePicker tp = (TimePicker) findViewById(R.id.timePicker2);

        btnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                date = cv.getDate();
                time = tp.getHour()+tp.getMinute();
                Intent startQ2Activity = new Intent(booking.this,Confirmation.class);
                startQ2Activity.putExtra("date", date);
                startQ2Activity.putExtra("time", time);
                startActivity(startQ2Activity);
            }
        });
    }
}

