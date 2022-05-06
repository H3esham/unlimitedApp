package com.example.praise.utility;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.praise.R;

public class BaseActivity extends AppCompatActivity {

    public Toolbar myToolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_aboutUs:
//                move to about us activity
                View view = new View(this);
                Intent intent = new Intent(view.getContext(), com.example.praise.pages.AboutUsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_exit:
                // exit the app and kill the process
                finish();
                return true;
            case android.R.id.home:
                finish();
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
