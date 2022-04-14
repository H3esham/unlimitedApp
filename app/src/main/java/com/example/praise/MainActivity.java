package com.example.praise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView praise;
    private Button minusBtn;
    private Button plusBtn;
    private Button resetBtn;
    private int counter;
    /**
     * afahsfagtest doc
     */
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
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
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        praise=(TextView) findViewById(R.id.praise);
        minusBtn=(Button) findViewById(R.id.minusBtn);
        minusBtn.setOnClickListener(clickListener);
        plusBtn=(Button) findViewById(R.id.plusBtn);
        plusBtn.setOnClickListener(clickListener);
        resetBtn=(Button) findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(clickListener);

       initCounter();

        }
        private void initCounter(){
            counter=0;
            praise.setText(counter+"");
    }
    private void plusCounter(){
        counter++;
        praise.setText(counter+"");

    } private void minusCounter(){
        counter--;
        praise.setText(counter+"");
    }

}