package com.sma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);

    }


    public void collegeweb(View view) {
        Intent webs = new Intent(this, MainColleges.class);

        startActivity(webs);

    }

    public void bus(View view) {
        Intent buses = new Intent(this, MainBus.class);

        startActivity(buses);
    }
}
