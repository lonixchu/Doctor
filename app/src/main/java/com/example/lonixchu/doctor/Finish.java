package com.example.lonixchu.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        final FloatingActionButton btnA = (FloatingActionButton) findViewById(R.id.buttonA);

        btnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startQ2Activity = new Intent(v.getContext(), home.class);
                startActivity(startQ2Activity);
            }
        });
    }
}
