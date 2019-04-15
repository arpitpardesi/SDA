package com.sma;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainUpdates extends AppCompatActivity {

    TextInputLayout Mess;
    Button Update;
    EditText messsub;
    String formattedDate;
    DatabaseReference DatabaseMess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updates);

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        formattedDate = df.format(c);
        messsub = findViewById(R.id.editTextMSub);
        Mess = findViewById(R.id.editTextMess);
        Update = findViewById(R.id.buttonUpdates);

        DatabaseMess = FirebaseDatabase.getInstance().getReference("Updates");
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertype();
            }
        });
    }

    private void usertype() {
        String sub = messsub.getText().toString().trim();
        String mess = Mess.getEditText().getText().toString().trim();
        String date = formattedDate;


        if(!TextUtils.isEmpty(mess)){
            UpdateF fData = new UpdateF(sub,date, mess);
            DatabaseMess.child(sub).setValue(fData);
            Toast.makeText(this, "Updated", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Please enter message", Toast.LENGTH_LONG).show();
        }
    }
}
