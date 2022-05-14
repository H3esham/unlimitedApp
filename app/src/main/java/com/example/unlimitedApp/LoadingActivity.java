package com.example.unlimitedApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.unlimitedApp.pages.auth.login.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoadingActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        //go to the main activity
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                mAuth = FirebaseAuth.getInstance();
                if (mAuth.getCurrentUser() != null) {
                    intent = new Intent(LoadingActivity.this, HomePageActivity.class);
                }else{
                    intent = new Intent(LoadingActivity.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 1000);

    }
}