package com.sma;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainExisting extends AppCompatActivity {

    private DatabaseReference pDatabase,ref, database;
    private ListView listView;

    private ArrayList<String> arraylist = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_existing);

        database = FirebaseDatabase.getInstance().getReference();
        ref = database.child("Students");
        listView = findViewById(R.id.listExist);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist );

        listView.setAdapter(arrayAdapter);

        database.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                try{
                    String string = dataSnapshot.getValue(String.class);
                    arraylist.add(string);


                }
                catch (Exception e){
                    String ex = e.toString();
                    arraylist.add(ex);
                    Toast.makeText(MainExisting.this, ex, Toast.LENGTH_SHORT).show();
                }

                //String string = dataSnapshot.getValue(String.class);


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
        });

/*
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> td = (HashMap<String,Object>) dataSnapshot.getValue();

                for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
                    DatabaseReference objRef = ref.child( childDataSnapshot.getKey());
                    Map<String,Object> taskMap = new HashMap<String,Object>();
                    //taskMap.put("is_read", "1");
                    objRef.updateChildren(taskMap); //should I use setValue()...?

                    //System.out.print(childDataSnapshot.getKey());
                    Log.v("Testing",""+ childDataSnapshot.getKey()); //displays the key for the node
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
        */

    }
}
