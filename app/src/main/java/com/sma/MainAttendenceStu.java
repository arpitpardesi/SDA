package com.sma;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainAttendenceStu extends AppCompatActivity {

    private String mo;
    private TextView roll, month, dp, td;
    private DatabaseReference pDatabase,ref, database;
    private ChildEventListener pPostListener;
    private Spinner spinner;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_attendence_stu);

        roll = findViewById(R.id.textViewRNA);
        month = findViewById(R.id.textViewMonA);
        dp = findViewById(R.id.textViewDP);
        td = findViewById(R.id.textViewTD);
        spinner = findViewById(R.id.spinnerMOnthA);
        button = findViewById(R.id.buttonUpA);
        mo = spinner.getSelectedItem().toString().trim();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onStop() {
        super.onStop();
        if (pPostListener != null) {
            ref.removeEventListener(pPostListener);
        }
    }

    public void fromAtt(View view) {
        database = FirebaseDatabase.getInstance().getReference();
        ref = database.child("Attendence").child(mo);
        ChildEventListener postListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                AttenStu attenStu = dataSnapshot.getValue(AttenStu.class);
                // [START_EXCLUDE]
                assert attenStu != null;
                roll.setText(attenStu.Enroll);
                month.setText(attenStu.Month);
                dp.setText(attenStu.Days_Present);
                td.setText(attenStu.Total_Days);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        ref.addChildEventListener(postListener);
        pPostListener = postListener;
    }
}
