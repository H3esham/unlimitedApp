package com.example.unlimitedApp.tools.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;

public class MainActivity extends BaseActivity {
    private  int seconds;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_stopwatch_activity_main);

        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle(getString(R.string.tools_stopwatch_title));
            setSupportActionBar(myToolbar);
        }

        if (savedInstanceState !=null){
            savedInstanceState.getInt("seconds");
            savedInstanceState.getBoolean("running");
            savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }
    public void onStart(View view){
        running = true;
    }
    public void onStop(View view){
        running =false;
    }
    public void onReset(View view){
        running =false;
        seconds=0;
    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning=running;
        running = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning){
            running =true;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds",seconds);
        outState.putBoolean("running",running);
        outState.putBoolean("wasRunning",wasRunning);
    }

    private void runTimer() {
        TextView timeView =findViewById(R.id.textView);
        Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours =seconds/3600;
                int minutes =(seconds % 3600)/60;
                int secs =seconds % 60;
                String time =String.format(Locale.getDefault(), "%d:%02d:%02d", hours,minutes,secs);
                timeView.setText(time);
                if (running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }
}