package com.sma;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainUpdateStu extends AppCompatActivity {
    //List View
    private ListView listView;
    private TextView mDate, mMessage, mSubject;
    //Firebase reference
    private DatabaseReference mDatabase;
    private ChildEventListener mPostListener;

    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update_stu);

        //listView = (ListView)findViewById(R.id.Message);

        //use child() if node is child in Firebase datebase
        mDate = findViewById(R.id.textViewDate);
        mMessage = findViewById(R.id.textViewMessage);

        //Used to allow scrolling in the message
        mMessage.setMovementMethod(new ScrollingMovementMethod());

        mSubject = findViewById(R.id.textViewSub);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Updates");



    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPostListener != null) {
            mDatabase.removeEventListener(mPostListener);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        ChildEventListener postListener =new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                UpdatesStudent post = dataSnapshot.getValue(UpdatesStudent.class);
                // [START_EXCLUDE]
                assert post != null;
                mDate.setText(post.Date);
                mSubject.setText(post.Subject);
                mMessage.setText(post.Message);
                // [END_EXCLUDE]
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
   /*
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                UpdatesStudent post = dataSnapshot.getValue(UpdatesStudent.class);
                // [START_EXCLUDE]
                mDate.setText(post.ID);
                mMessage.setText(post.Name);
                mSubject.setText(post.Type);
                // [END_EXCLUDE]
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                String TAG = "Updates";
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                // [START_EXCLUDE]
                Toast.makeText(MainUpdateStu.this, "Failed to load post.",
                        Toast.LENGTH_SHORT).show();
                // [END_EXCLUDE]
            }
        };
        */
        mDatabase.addChildEventListener(postListener);
        mPostListener = postListener;

    }
}
