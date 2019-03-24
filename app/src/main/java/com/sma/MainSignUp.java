package com.sma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainSignUp extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextE;
    private EditText editTextP;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.textviewSU).setOnClickListener(this);


/*
        editTextE =(EditText) findViewById(R.id.editTextEmail);
        editTextP =(EditText) findViewById(R.id.editTextPassword);
        mAuth = FirebaseAuth.getInstance();
*/      //findViewById(R.id.buttonSU).setOnClickListener(this);
    }

    @Override

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    private void registerUser() {
        String email = editTextE.getText().toString().trim();
        String password= editTextP.getText().toString().trim();

        if (email.isEmpty()){
            editTextE.setError("Email required");
            editTextE.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextE.setError("Enter a valid email");
            editTextE.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextP.setError("Password required");
            editTextP.requestFocus();
            return;
        }

        if (password.length()<6){
            editTextP.setError("Minimum length of password is 6");
            editTextP.requestFocus();
            return;
        }



    }

    public void onClick(View view) {

        switch (view.getId()){
            /*case R.id.buttonsignup:
                registerUser();
                break;
*/
            case R.id.textviewSU:
                startActivity(new Intent(this, MainLogin.class));
                break;
        }
/*
        String email = editTextE.getText().toString().trim();
        String password= editTextP.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainSignUp.this,"User Registered Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainSignUp.this, MainLogin.class);
                    startActivity(i);
                }
                else{
                    Log.e("Error", task.getException().getMessage());
                    Toast.makeText(MainSignUp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                }
            }
        });
*/

    }

}
