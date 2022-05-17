package com.example.unlimitedApp.tools.notepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.recyclerviewlist.TodoAdapter;
import com.example.unlimitedApp.utility.BaseActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends BaseActivity {
    EditText text;
    MenuItem action_delete_all,action_save_all;
    FirebaseAuth mAuth;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.toolbar_main, menu);
        action_delete_all = menu.findItem(R.id.action_delete_all);
        action_delete_all.setVisible(true);
        action_save_all = menu.findItem(R.id.action_save_all);
        action_save_all.setVisible(true);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View view = new View(this);
        switch (item.getItemId()) {
            case R.id.action_delete_all:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(getString(R.string.tools_notepad_delete_all_title));
                builder.setMessage(getString(R.string.tools_notepad_delete_all_message));
                builder.setPositiveButton(getString(R.string.tools_notepad_delete_all_positive), (dialog, which) -> {
                    text.setText("");
                    Toast.makeText(this, "delete all text", Toast.LENGTH_SHORT).show();
                });
                builder.setNegativeButton(getString(R.string.tools_notepad_delete_all_negative), (dialog, which) -> {
                    dialog.dismiss();
                });
                builder.show();
                return true;
            case R.id.action_save_all:
                // check if user is logged in
                if (mAuth.getCurrentUser() != null) {
                    // save text to firebase
                    String text_to_save = text.getText().toString();
                    if (text_to_save.isEmpty()) {
                        Toast.makeText(this, "text is empty", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(this, "save all text", Toast.LENGTH_SHORT).show();
                        // save text to firebase
                        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
                        db.child("users")
                                .child(mAuth.getCurrentUser().getUid())
                                .child("text")
                                .setValue(text_to_save)
                                .addOnCompleteListener(task -> {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(this, "text saved", Toast.LENGTH_SHORT).show();
                                    }else{

                                        // save text to local
                                        SharedPreferences sharedPreferences = getSharedPreferences("text", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        editor.putString("text", text_to_save);
                                        editor.apply();
                                        Toast.makeText(this, "text saved", Toast.LENGTH_SHORT).show();

                                    }
                                });
                    }

                }else{
                    // save text to local storage
                    Toast.makeText(this, "save all text", Toast.LENGTH_SHORT).show();
                    String text_to_save = text.getText().toString();
                    if (text_to_save.isEmpty()) {
                        Toast.makeText(this, "text is empty", Toast.LENGTH_SHORT).show();
                    }else {
                        // save text to local storage
                        SharedPreferences sharedPreferences = getSharedPreferences("text", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("text", text_to_save);
                        editor.apply();
                        Toast.makeText(this, "text saved", Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toos_notepad_activity_main);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle(getString(R.string.tools_notepad_title));
            // show delete icon in action bar
            setSupportActionBar(myToolbar);
        }
        mAuth = FirebaseAuth.getInstance();
        text = (EditText) findViewById(R.id.text);

        // load text from firebase
        if (mAuth.getCurrentUser() != null) {
            DatabaseReference db = FirebaseDatabase.getInstance().getReference();
            db.child("users")
                    .child(mAuth.getCurrentUser().getUid())
                    .child("text")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                String text_to_load = dataSnapshot.getValue(String.class);
                                text.setText(text_to_load);
                            }else{
                                // load text from local storage
                                SharedPreferences sharedPreferences = getSharedPreferences("text", Context.MODE_PRIVATE);
                                String text_to_load = sharedPreferences.getString("text", "");
                                text.setText(text_to_load);
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
        }else{
            // load text from local storage
            SharedPreferences sharedPreferences = getSharedPreferences("text", Context.MODE_PRIVATE);
            String text_to_load = sharedPreferences.getString("text", "");
            text.setText(text_to_load);
        }

    }

}