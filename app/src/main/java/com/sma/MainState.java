package com.sma;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainState extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_state);

        //findViewById(R.id.buttonSubmit).setOnClickListener(this);

    }


    public void dashboard(View view) {
        Intent webs = new Intent(this, MainDashboard.class);
        startActivity(webs);
    }
/*
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonsignup:
                startActivity(new Intent(this,MainDashboard.class));
                break;       }

    }
  */
}
