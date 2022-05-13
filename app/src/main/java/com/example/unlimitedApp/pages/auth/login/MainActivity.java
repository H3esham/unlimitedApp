package com.example.unlimitedApp.pages.auth.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.unlimitedApp.R;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView register_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages_login_activity);

        register_btn = (TextView) findViewById(R.id.login_btn);
        register_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                Intent intent = new Intent(v.getContext(), com.example.unlimitedApp.pages.auth.register.MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}