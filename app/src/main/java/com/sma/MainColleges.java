package com.sma;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainColleges extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_colleges);
        Configuration config = getResources().getConfiguration();

        WebView webView = findViewById(R.id.webviewColl);
        webView.loadUrl("www.google.com");

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
}
