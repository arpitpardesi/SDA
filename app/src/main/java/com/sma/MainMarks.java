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

public class MainMarks extends AppCompatActivity {

    EditText Enroll, Mark;
    Spinner Sem,Sub,Mst;
    Integer Marks;
    Button UM;
    DatabaseReference DatabaseMarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_marks);

        Enroll = findViewById(R.id.editTextRN);
        Sem = findViewById(R.id.spinnerSem);
        Sub = findViewById(R.id.spinnerSubj);
        Mst = findViewById(R.id.spinnerMst);
        Mark = findViewById(R.id.editTextMark);
        //Marks = (Integer) Integer.parseInt(Mark);

        UM = findViewById(R.id.buttonUM);

        DatabaseMarks = FirebaseDatabase.getInstance().getReference("Marks");
        UM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertype();
            }
        });
    }

    private void usertype() {
        String enroll = Enroll.getText().toString().trim().toUpperCase();
        String sem = Sem.getSelectedItem().toString().trim().toUpperCase();
        String sub = Sub.getSelectedItem().toString().trim().toUpperCase();
        String mst = Mst.getSelectedItem().toString().trim().toUpperCase();
        String mark = Mark.getText().toString().trim();
        Integer marks = Integer.parseInt(mark);


        if(!TextUtils.isEmpty(enroll)){
            Marks fData = new Marks(enroll, sem, sub, mst, marks);
            DatabaseMarks.child(sem).child(enroll).child(mst).child(sub).setValue(fData);
            Toast.makeText(this, "Marks Updated", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Enter Enrollment number ", Toast.LENGTH_LONG).show();
        }

    }
}
