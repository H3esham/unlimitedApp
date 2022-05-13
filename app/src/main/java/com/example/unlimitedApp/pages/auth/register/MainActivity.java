package com.example.unlimitedApp.pages.auth.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unlimitedApp.HomePageActivity;
import com.example.unlimitedApp.R;
import com.example.unlimitedApp.models.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView login_btn;

    EditText fullName, age, email, password, confirmPassword;

    ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages_register_activity);
        // progress bar for loading
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        //set back button (back to login page)
        login_btn = (TextView) findViewById(R.id.login_btn);
        login_btn.setLinksClickable(true);

        //set form inputs
        fullName = (EditText) findViewById(R.id.fullName);
        age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);


        login_btn.setOnClickListener(this);
        findViewById(R.id.register).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                startActivity(new Intent(v.getContext(), com.example.unlimitedApp.pages.auth.login.MainActivity.class));
                break;
            case R.id.register:
                registerUser();
                break;
        }
    }

    public void registerUser() {

        String fullName = this.fullName.getText().toString();
        String age = this.age.getText().toString();
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();
        String confirmPassword = this.confirmPassword.getText().toString();

        if (fullName.isEmpty()) {
            this.fullName.setError("Full Name is required");
            this.fullName.requestFocus();
            return;
        }
        if (age.isEmpty()) {
            this.age.setError("Age is required");
            this.age.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            this.email.setError("Email is required");
            this.email.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            this.password.setError("Password is required");
            this.password.requestFocus();
            return;
        }
        if (confirmPassword.isEmpty()) {
            this.confirmPassword.setError("Confirm Password is required");
            this.confirmPassword.requestFocus();
            return;
        }

        if (!password.equals(confirmPassword)) {
            this.confirmPassword.setError("Password does not match");
            this.confirmPassword.requestFocus();
            return;
        }

        if (age.length() > 2) {
            this.age.setError("Age must be less than 3 digits");
            this.age.requestFocus();
            return;
        }

        if (email.length() > 30) {
            this.email.setError("Email must be less than 30 characters");
            this.email.requestFocus();
            return;
        }

        if(!(email.contains("@") && email.contains("."))) {
            this.email.setError("Email must be valid");
            this.email.requestFocus();
            return;
        }

        if (password.length() > 30) {
            this.password.setError("Password must be less than 30 characters");
            this.password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        // use firebase to register user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            System.out.println("User registered successfully");
                            // Sign in success, update UI with the signed-in user's information
                            System.out.println(mAuth.getCurrentUser().getUid());
                            // change age from string to int
                            int ageInt = Integer.parseInt(age);
                            User user = new User(fullName,email,password,ageInt);
                            // add user to database
                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                    }
                                } //end onComplete
                                    }); //end setValue
                            } else {
                                // registration failed
                                Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}