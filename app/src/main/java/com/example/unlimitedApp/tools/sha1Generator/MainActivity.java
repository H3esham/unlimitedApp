package com.example.unlimitedApp.tools.sha1Generator;


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
        setContentView(R.layout.tools_sha1_generator_activity_main);
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
                if (input.length() > 0 && getSHA1(input) != null) {

                    //add text to outputText
                    outputText.setText("Result: "+getSHA1(input));
                    outputText.setVisibility(View.VISIBLE);
                    Toast.makeText(com.example.unlimitedApp.tools.sha1Generator.MainActivity.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();

                    //copy text to clipboard
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("sha1", getSHA1(input));
                    clipboard.setPrimaryClip(clip);

                }

            }
        });
    }

    public static String getSHA1(String input) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-1");
            byte[] sha1hash = new byte[40];
            md.update(input.getBytes("iso-8859-1"), 0, input.length());
            sha1hash = md.digest();
            return convertToHex(sha1hash);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9))
                    buf.append((char) ('0' + halfbyte));
                else
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }


}