package com.example.lonixchu.doctor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        WebView myWebView = (WebView) findViewById(R.id.webview);
        Bundle mBundle = getIntent().getExtras();
        myWebView.loadUrl("https://www.google.com.hk/maps/search/"+mBundle.getString("FindLocation"));
    }
}
