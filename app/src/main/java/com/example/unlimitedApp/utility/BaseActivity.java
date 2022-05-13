package com.example.unlimitedApp.utility;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.unlimitedApp.R;
import com.google.firebase.auth.FirebaseAuth;

public class BaseActivity extends AppCompatActivity {

    public Toolbar myToolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_main, menu);
        // check if the user is logged in
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        menu.findItem(R.id.action_login).setVisible(false);
        menu.findItem(R.id.action_logout).setVisible(false);

        if (mAuth.getCurrentUser() != null) {
            // user is logged in
            menu.findItem(R.id.action_logout).setVisible(true);
        }else{
            // user is not logged in
            menu.findItem(R.id.action_login).setVisible(true);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View view = new View(this);
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_aboutUs:
//                move to about us activity
                intent = new Intent(view.getContext(), com.example.unlimitedApp.pages.AboutUsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings:
//                move to Settings activity
                intent = new Intent(view.getContext(), com.example.unlimitedApp.pages.SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_exit:
                // exit the app and kill the process
                finish();
                return true;
            case android.R.id.home:
                finish();
            case R.id.action_login:
                // move to login activity
                intent = new Intent(view.getContext(), com.example.unlimitedApp.pages.auth.login.MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_logout:
                // logout the user
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
                // move to login activity
                intent = new Intent(view.getContext(), com.example.unlimitedApp.pages.auth.login.MainActivity.class);
                startActivity(intent);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
