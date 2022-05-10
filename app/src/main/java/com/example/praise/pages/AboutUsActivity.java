package com.example.praise.pages;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.praise.R;
import com.example.praise.utility.BaseActivity;

public class AboutUsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages_about_us_activity);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle("About Us");
            myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intenBack = new Intent(view.getContext(),com.example.praise.HomePageActivity.class);
                    startActivity(intenBack);
                }
            });
            setSupportActionBar(myToolbar);
        }
    }
}