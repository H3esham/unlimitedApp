package com.example.unlimitedApp.tools.sha256Generator;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_sha256_generator_activity_main);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            setSupportActionBar(myToolbar);
        }
        // Get the button view
        Button button = findViewById(R.id.button);
        TextView inputText = findViewById(R.id.input);
        TextView outputText = findViewById(R.id.Result);
        // Set a click listener on that View
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String input = inputText.getText().toString();
                // check if input is empty
                if (input.length() > 0 && getSHA256(input) != null) {

                    //add text to outputText
                    outputText.setText(getString(R.string.result)+getSHA256(input));
                    outputText.setVisibility(View.VISIBLE);
                    Toast.makeText(com.example.unlimitedApp.tools.sha256Generator.MainActivity.this, getString(R.string.copy_to_clipboard), Toast.LENGTH_SHORT).show();

                    //copy text to clipboard
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("sha256", getSHA256(input));
                    clipboard.setPrimaryClip(clip);

                }

            }
        });
    }
    
    public static String getSHA256(String input) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] array = md.digest(input.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
    
}