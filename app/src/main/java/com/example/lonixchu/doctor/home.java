package com.example.lonixchu.doctor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final FloatingActionButton btnA = (FloatingActionButton) findViewById(R.id.buttonA);
        final FloatingActionButton btnB = (FloatingActionButton) findViewById(R.id.buttonB);
        final FloatingActionButton btnC = (FloatingActionButton) findViewById(R.id.buttonC);
        final FloatingActionButton btnD = (FloatingActionButton) findViewById(R.id.buttonD);
        final AlertDialog alertDialog = new AlertDialog.Builder(home.this).create();

        btnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startQ2Activity = new Intent(v.getContext(), doctorindex.class);
                startActivity(startQ2Activity);
            }
        });

        btnB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startQ2Activity = new Intent(v.getContext(), forum.class);
                startActivity(startQ2Activity);
            }
        });

        btnC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startQ2Activity = new Intent(v.getContext(), profile.class);
                startActivity(startQ2Activity);
            }
        });

        btnD.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                alertDialog.setTitle("Logout");
                alertDialog.setMessage("Are you sure you want to Logout?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent startQ2Activity = new Intent(home.this, login.class);
                                startActivity(startQ2Activity);
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
    }
}
