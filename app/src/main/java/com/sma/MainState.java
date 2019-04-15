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
    Spinner state, city, university, colleges;
    String State, City, University, College;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_state);

        state = findViewById(R.id.spinnerState);
        city = findViewById(R.id.spinnerCity);
        university = findViewById(R.id.spinnerUniversity);
        colleges = findViewById(R.id.spinnerColleges);

        //findViewById(R.id.buttonSubmit).setOnClickListener(this);

    }


    public void dashboard(View view) {
        State = state.getSelectedItem().toString().trim();
        City = city.getSelectedItem().toString().trim();
        University = university.getSelectedItem().toString().trim();
        College = colleges.getSelectedItem().toString().trim();
        if(State.equals("Madhya Pradesh") && City.equals("Indore") && University.equals("RGPV") && College.equals("Acropolis Technical Campus"))
        {
            finish();
            startActivity(new Intent(this, MainDashboard.class));
        }
        else{
            Toast.makeText(this, "ATC only", Toast.LENGTH_LONG).show();
        }
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
