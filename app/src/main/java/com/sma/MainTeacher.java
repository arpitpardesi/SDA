package com.sma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_teacher);
    }

    public void rnu(View view) {
        Intent i = new Intent(this, MainNewUser.class);
        startActivity(i);
    }

    public void logoutT(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
        Toast.makeText(getApplicationContext(), "Logout Successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }

    public void toAttend(View view) {
        startActivity(new Intent(this, MainAttendenceTe.class));
    }

    public void toMarks(View view) {
        startActivity(new Intent(this, MainMarks.class));
    }

    public void toUpdate(View view) {
        startActivity(new Intent(this, MainUpdates.class));
    }
}
