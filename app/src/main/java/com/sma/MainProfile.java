package com.sma;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainProfile extends AppCompatActivity {

    private TextView pname, proll, pemail, pdept, psect, pyear;
    private EditText roll;
    private DatabaseReference pDatabase,ref, database;
    private ChildEventListener pPostListener;
    private String SRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
        roll = findViewById(R.id.editTextRoll);
        pname = findViewById(R.id.textViewName1);
        pemail= findViewById(R.id.textViewEmail1);
        proll = findViewById(R.id.textViewRN1);
        pdept = findViewById(R.id.textViewDept1);
        psect = findViewById(R.id.textViewSect1);
        pyear = findViewById(R.id.textViewYear1);

        SRoll = roll.getText().toString().trim().toUpperCase();
        database = FirebaseDatabase.getInstance().getReference();
        ref = database.child("Students").child(SRoll);

        //pDatabase = FirebaseDatabase.getInstance().getReference().child("Students");

    }
/*
    public void fromFirebase(View view) {
        //pDatabase = FirebaseDatabase.getInstance().getReference().child("Students").child(Roll);
        ref = database.child("Students").child(Roll);
        onStart();
    }
*/
    @Override
    protected void onStart() {
        super.onStart();
        //pDatabase.addChildEventListener(new ChildEventListener() {
        ChildEventListener postListener =new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ProfileStu profileStu = dataSnapshot.getValue(ProfileStu.class);
                // [START_EXCLUDE]
                assert profileStu != null;
                pname.setText(profileStu.SName);
                pemail.setText(profileStu.SEmail);
                proll.setText(profileStu.SRoll);
                pdept.setText(profileStu.SBranch);
                psect.setText(profileStu.SSect);
                pyear.setText(profileStu.SYear);

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
        //mDatabase.addChildEventListener(postListener);
        ref.addChildEventListener(postListener);
        pPostListener = postListener;



    }

    @Override
    protected void onStop() {
        super.onStop();
        if (pPostListener != null) {
            ref.removeEventListener(pPostListener);
        }
    }
}
