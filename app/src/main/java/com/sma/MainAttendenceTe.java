package com.sma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainAttendenceTe extends AppCompatActivity {

    EditText Roll, DB, TD;
    Spinner Month;
    Button Update;
    DatabaseReference DatabaseAtten;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_attendence_te);

        Roll = (EditText)findViewById(R.id.editTextARN);
        Month = (Spinner)findViewById(R.id.spinnerAM);
        DB = (EditText)findViewById(R.id.editTextDP);
        TD = (EditText)findViewById(R.id.editTextTD);

        Update = findViewById(R.id.buttonAU);

        DatabaseAtten = FirebaseDatabase.getInstance().getReference("Attendence");
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertype();
            }
        });

    }
    private void usertype() {
        String enroll = Roll.getText().toString().trim().toUpperCase();
        String mon = Month.getSelectedItem().toString().trim().toUpperCase();
        String dp = DB.getText().toString().trim();
        String td = TD.getText().toString().trim();



        if(!TextUtils.isEmpty(enroll)){
            AttenTe fData = new AttenTe(enroll,td,dp,mon);
            DatabaseAtten.child(enroll).child(mon).setValue(fData);
            Toast.makeText(this, "Attendance Updated", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Enter Enrollment number ", Toast.LENGTH_LONG).show();
        }

    }
}
