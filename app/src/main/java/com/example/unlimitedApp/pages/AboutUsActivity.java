package com.example.unlimitedApp.pages;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;

public class AboutUsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages_about_us_activity);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle(getString(R.string.about_us_title));
            myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(view.getContext(),com.example.unlimitedApp.HomePageActivity.class));
                }
            });
            setSupportActionBar(myToolbar);
        }
    }
}