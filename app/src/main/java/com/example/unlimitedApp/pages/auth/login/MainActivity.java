package com.example.unlimitedApp.pages.auth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unlimitedApp.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final private String TAG = "Pages_LOGIN_MainActivity";

    TextView register_btn,without_login_btn;
    EditText email,password;
    Button login_btn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages_login_activity);

        mAuth = FirebaseAuth.getInstance();

        register_btn = (TextView) findViewById(R.id.register_btn);
        register_btn.setOnClickListener(this);

        without_login_btn = (TextView) findViewById(R.id.without_login_btn);
        without_login_btn.setOnClickListener(this);


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);

        login_btn = (Button) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_btn:
                startActivity(new Intent(v.getContext(), com.example.unlimitedApp.pages.auth.register.MainActivity.class));
                break;
            case R.id.without_login_btn:
                startActivity(new Intent(v.getContext(), com.example.unlimitedApp.HomePageActivity.class));
                break;
            case R.id.login_btn:
                loginUser();
                break;
        }
    }


    public void loginUser(){
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();
        if(email.isEmpty()){
            this.email.setError("Email is required");
            this.email.requestFocus();
            return;
        }

        if(password.isEmpty()){
            this.password.setError("Password is required");
            this.password.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            this.email.setError("Please enter a valid email");
            this.email.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Intent intent = new Intent(MainActivity.this, com.example.unlimitedApp.HomePageActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        // If sign in fails, display a message to the user.
//                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}