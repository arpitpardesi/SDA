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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;


public class MainSignUp extends AppCompatActivity implements View.OnClickListener {
    EditText editTextE;
    EditText editTextP;
    private FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;
    SignInButton buttonsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sign_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.textviewSU).setOnClickListener(this);

        editTextE = (EditText) findViewById(R.id.editTextEmail);
        editTextP = (EditText) findViewById(R.id.editTextPassword);
        mAuth = FirebaseAuth.getInstance();

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

/*
        buttonsi = findViewById(R.id.googlesignup);
        buttonsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 101);
            }
        });
*/

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

/*
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 101);
    }
*/

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 101) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                //assert account != null;
                if (account != null) {
                    firebaseAuthWithGoogle(account);
                }
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately

                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(getApplicationContext(), MainState.class);
                            startActivity(i);
                            finish();
                            Toast.makeText(getApplicationContext(), "User signup successfully", Toast.LENGTH_SHORT).show();

                        } else {

                            Toast.makeText(getApplicationContext(), "User SignUp Failed", Toast.LENGTH_SHORT).show();
                        }
                        // If sign in fails, display a message to the user.


                    }

                    // ...
                });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textviewSU:
                startActivity(new Intent(this, MainLogin.class));
                break;
        }
    }

    public void GoogleSU(View view) {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, 101);
    }
}




//Used below code earlier

/*
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
              case R.id.buttonsignup:
                registerUser();
                break;

        case R.id.textviewSU:
        startActivity(new Intent(this, MainLogin.class));
        break;
        }

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