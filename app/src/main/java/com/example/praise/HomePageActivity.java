package com.example.praise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.praise.models.Category;
import com.example.praise.recyclerviewlist.CategoryAdapter;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Category[] categories = new Category[]{
                new Category("Praise","Praise is a tool to convert Arabic numerals to English numerals" ,R.drawable.background_design),
                new Category("Number Convert","Praise is a tool to convert Arabic numerals to English numerals", R.drawable.background_design),
                new Category("Currency Convert", "Praise is a tool to convert Arabic numerals to English numerals",R.drawable.background_design),
                new Category("Qibla","Praise is a tool to convert Arabic numerals to English numerals", R.drawable.background_design)
        };


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CategoryAdapter(categories));


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
           case "currencyConvert":
                intent = new Intent(this, com.example.praise.tools.currencyConvert.MainActivity.class);
               startActivity(intent);
               break;
           case "qibla":
                intent = new Intent(this, com.example.praise.tools.qibla.MainActivity.class);
               startActivity(intent);
               break;
        }
    }
}