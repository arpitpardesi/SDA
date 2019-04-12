package com.sma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class MainDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
/*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
*/
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuLogout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }

        return true;
    }
*/
    public void collegeweb(View view) {
        Intent webs = new Intent(this, MainColleges.class);

        startActivity(webs);

    }

    public void bus(View view) {
        Intent buses = new Intent(this, MainBus.class);

        startActivity(buses);
    }

    public void rnu(View view) {
        Intent i = new Intent(this, MainNewUser.class);
        startActivity(i);
    }


    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
        Toast.makeText(getApplicationContext(), "Logout Successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    public void toUpdateStu(View view) {
        startActivity(new Intent(this, MainUpdateStu.class));
    }
}
