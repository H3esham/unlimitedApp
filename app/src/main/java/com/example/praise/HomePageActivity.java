package com.example.praise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

    }

    public void goToPage(View view){
        Intent intent;
        String toolName = view.getTag().toString();
        switch (toolName){
            case "praise":
                intent = new Intent(this, com.example.praise.tools.praise.MainActivity.class);
                startActivity(intent);
                break;
           case "numberConvert":
                intent = new Intent(this, com.example.praise.tools.numberConvert.MainActivity.class);
               startActivity(intent);
               break;
        }
    }
}