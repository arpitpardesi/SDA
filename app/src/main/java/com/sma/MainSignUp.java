package com.sma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    EditText editTextE, editTextP;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.textviewSU).setOnClickListener(this);
/*
        editTextE =findViewById(R.id.editTextEmail);
        editTextP =findViewById(R.id.editTextPassword);

        mAuth = FirebaseAuth.getInstance();
*/


        //findViewById(R.id.buttonSU).setOnClickListener(this);



    }

    @Override
/*
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
 */
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonsignup:
                registerUser();
                break;

            case R.id.textviewSU:
                startActivity(new Intent(this, MainLogin.class));
                break;
        }
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

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"User Registered Successful", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
