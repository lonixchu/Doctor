package com.example.lonixchu.doctor;

import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {

    TextView name;
    TextView location;
    TextView times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        name  = (TextView) findViewById(R.id.doctorname);
        location = (TextView) findViewById(R.id.location);
        times = (TextView) findViewById(R.id.time);

        Bundle mBundle = getIntent().getExtras();

        name.setText(mBundle.getString("Name"));
        location.setText(mBundle.getString("Location"));
        times.setText(mBundle.getString("Date"));

        final Button btnA = (Button) findViewById(R.id.changeprofile);
        final Button btnB = (Button) findViewById(R.id.changedoctor);
        final EditText txtDate=(EditText)findViewById(R.id.time);
        final Button btnE = (Button) findViewById(R.id.confirm);
        final Button map = (Button) findViewById(R.id.mapping);
        final AlertDialog alertDialog = new AlertDialog.Builder(Confirmation.this).create();



        btnB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startQ2Activity = new Intent(v.getContext(), finddoctor.class);
                startActivity(startQ2Activity);
            }
        });



        btnE.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                alertDialog.setTitle("CONFIRMATION");
                alertDialog.setMessage("Are you sure you want to submit the reservation?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "CONFIRM",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent startQ2Activity = new Intent(Confirmation.this, Finish.class);
                                startActivity(startQ2Activity);
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });

        map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Bundle mBundle = getIntent().getExtras();
                Intent saveIntent = new Intent(Confirmation.this, map.class);
                saveIntent.putExtra("FindLocation", mBundle.getString("Location"));
                startActivity(saveIntent);
            }
        });
    }

    public void onStart(){
        super.onStart();

        EditText txtDate=(EditText)findViewById(R.id.time);
        txtDate.setOnFocusChangeListener(new View.OnFocusChangeListener(){
                @Override
                public void onFocusChange(View view, boolean hasfocus){
                    if(hasfocus){
                        DateDialog dialog=new DateDialog(view);
                        FragmentTransaction ft =getFragmentManager().beginTransaction();
                        dialog.show(ft, "DatePicker");

                    }
                }

        });
    }
}
