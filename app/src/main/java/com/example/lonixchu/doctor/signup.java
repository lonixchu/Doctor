package com.example.lonixchu.doctor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class signup extends AppCompatActivity {

    private TextView sin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final Button btnA = (Button) findViewById(R.id.create);
        final AlertDialog alertDialog2 = new AlertDialog.Builder(signup.this).create();
        final AlertDialog alertDialog = new AlertDialog.Builder(signup.this).create();
        final EditText email = (EditText) findViewById(R.id.mal);
        final EditText username = (EditText) findViewById(R.id.usrusr);
        final EditText password = (EditText) findViewById(R.id.pswd);
        sin = (TextView)findViewById(R.id.sin);


        sin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent it = new Intent(signup.this, login.class);
                startActivity(it);
            }
        });

        btnA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                if (email.getText() != null && username.getText() != null && password.getText() != null) {
                    alertDialog2.setTitle("Success");
                    alertDialog2.setMessage("You Created a Doctor+ Account! Sign in NOW!");
                    alertDialog2.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    Intent it = new Intent(signup.this, login.class);
                                    startActivity(it);
                                }
                            });

                    alertDialog.setTitle("Privacy");
                    alertDialog.setMessage("All record and history are protected by the privacy law. The information will be only used for the application. Are you willing to provide the medical record for Doctor+?");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ACCEPT",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    alertDialog2.show();
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DECLINE",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
                else{
                    alertDialog2.setTitle("WARNING");
                    alertDialog2.setMessage("Please fill in all the blanks");
                    alertDialog2.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                }
            }
        });
    }
}
