package com.example.lonixchu.doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity {

    private TextView sup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button btnA = (Button) findViewById(R.id.signin);
        sup = (TextView)findViewById(R.id.sup);
        sup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(login.this, signup.class);
                startActivity(it);
            }
        });

        btnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startQ2Activity = new Intent(v.getContext(), home.class);
                startActivity(startQ2Activity);
            }
        });
    }
}
