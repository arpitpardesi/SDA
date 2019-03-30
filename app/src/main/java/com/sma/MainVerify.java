package com.sma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainVerify extends AppCompatActivity {
    private Spinner VerifyType;
    private EditText VerifyPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_verify);

        VerifyType = (Spinner)findViewById(R.id.spinnerVerify);
        VerifyPass = (EditText)findViewById(R.id.editTextVerify);
    }

    public void verify(View view) {
        String VP = VerifyPass.getText().toString().trim();
        String VT = VerifyType.getSelectedItem().toString().trim();

        if(VT.equals("Student") && VP.equals("12345")){
            startActivity(new Intent(this,MainState.class));
            Toast.makeText(MainVerify.this,"Verified as Student",Toast.LENGTH_LONG).show();
            finish();
        }
        else if (VT.equals("Faculty") && VP.equals("abcd")){
            startActivity(new Intent(this, MainTeacher.class ));
            Toast.makeText(MainVerify.this,"Verified as Faculty",Toast.LENGTH_LONG).show();
            finish();
        }
        else if (VP.isEmpty()){
            Toast.makeText(MainVerify.this,"Please enter verification code",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainVerify.this,"Wrong user type or code",Toast.LENGTH_LONG).show();
        }
    }
}
