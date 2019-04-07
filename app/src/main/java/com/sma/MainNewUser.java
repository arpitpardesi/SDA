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

public class MainNewUser extends AppCompatActivity {

    EditText Name, Email, Roll;
    Spinner Branch, Sect, Year;
    Button Reg;
    DatabaseReference databaseNSR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new_user);

        Name = findViewById(R.id.editTextName);
        Email = findViewById(R.id.editTextEmail);
        Roll = findViewById(R.id.editTextRoll);
        Branch = findViewById(R.id.spinnerBranch);
        Sect = findViewById(R.id.spinnerSect);
        Year = findViewById(R.id.spinnerYear);

        Reg = findViewById(R.id.buttonRegister);

        databaseNSR = FirebaseDatabase.getInstance().getReference("Students");

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertype();
            }
        });
    }

    private void usertype(){
        String name = Name.getText().toString().trim().toUpperCase();
        String email = Email.getText().toString().trim();
        String roll = Roll.getText().toString().trim().toUpperCase();
        String branch = Branch.getSelectedItem().toString().trim().toUpperCase();
        String sect = Sect.getSelectedItem().toString().trim().toUpperCase();

        String year = Year.getSelectedItem().toString().trim();


        if(!TextUtils.isEmpty(name)){
            NSR fData = new NSR(name, email, roll, branch, sect, year);
            databaseNSR.child(roll).setValue(fData);
            Toast.makeText(this, "Student added", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Enter name", Toast.LENGTH_LONG).show();
        }
    }
}
