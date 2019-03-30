package com.sma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
    }

    public void forAdmin(View view) {
        switch (view.getId()){
            case R.id.buttonAF:
                startActivity(new Intent(MainAdmin.this, MainTeacher.class));
                break;
            case R.id.buttonAS:
                startActivity(new Intent(MainAdmin.this, MainDashboard.class));
                break;
        }
    }
}
