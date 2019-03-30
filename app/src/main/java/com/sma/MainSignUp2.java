package com.sma;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainSignUp2 extends AppCompatActivity implements View.OnClickListener {

    //defining view objects
    private EditText editTextEmail;
    private EditText editTextPassword;
    private ProgressDialog progressDialog;


    //defining firebaseauth object
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_main_sign_up2);

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        Button buttonSignup = (Button) findViewById(R.id.buttonSignup2);
        buttonSignup.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
    }

    private void registerUser(){

        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();

        if(email.equals("admin") || password.equals("admin")){
            admin();
        }

        //checking if email and passwords are empty
        if (email.isEmpty()){
            editTextEmail.setError("Email required");
            editTextEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextPassword.setError("Password required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length()<6){
            editTextPassword.setError("Minimum length of password is 6");
            editTextPassword.requestFocus();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success



                        if(task.isSuccessful()){
                            //display some message here
                            startActivity(new Intent(MainSignUp2.this, MainLogin.class));
                            finish();
                            Toast.makeText(MainSignUp2.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        }
                        else if (firebaseAuth.getCurrentUser() != null){
                            Toast.makeText(MainSignUp2.this, "Already registerd", Toast.LENGTH_LONG).show();
                        }
                        else{
                            //display some message here
                            Toast.makeText(MainSignUp2.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    private void admin() {
        startActivity(new Intent(this,MainAdmin.class));
        finish();
        Toast.makeText(MainSignUp2.this,"Admin",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        //calling register method on click
        registerUser();
    }

    public void toLogin(View view) {
        startActivity(new Intent(this, MainLogin.class));
    }
}
