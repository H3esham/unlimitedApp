package com.example.praise.tools.praise;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.praise.R;

public class MainActivity extends AppCompatActivity {
    private TextView praise;
    private Button minusBtn;
    private Button plusBtn;
    private Button resetBtn;
    private int counter;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.minusBtn:
                    minusCounter();
                    break;
                case R.id.plusBtn:
                    plusCounter();
                    break;
                case R.id.resetBtn:
                    initCounter();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_praise_main_activity);
        praise = (TextView) findViewById(R.id.p0);
        minusBtn = (Button) findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(clickListener);
        plusBtn = (Button) findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(clickListener);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(clickListener);

        initCounter();

    }

    @SuppressLint("SetTextI18n")
    private void initCounter() {
        counter = 0;
        praise.setText(counter + "");
    }

    @SuppressLint("SetTextI18n")
    private void plusCounter() {
        counter++;
        praise.setText(counter + "");

    }

    @SuppressLint("SetTextI18n")
    private void minusCounter() {
        counter--;
        praise.setText(counter + "");
    }

}