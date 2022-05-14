package com.example.unlimitedApp.tools.vigenereCipher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;

public class MainActivity extends BaseActivity {

    EditText message,key;
    RadioButton encrypt,decrypt;
    TextView message_handled;
    Button share_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_vigenere_cipher_activity_main);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle(getString(R.string.vigenereCipher_title));
            setSupportActionBar(myToolbar);
        }


        message = findViewById(R.id.message);
        key = findViewById(R.id.key);
        encrypt = findViewById(R.id.encrypt);
        decrypt = findViewById(R.id.decrypt);
        message_handled = findViewById(R.id.message_handled);
        share_btn = findViewById(R.id.share_btn);
        // make share_btn button is disabled
        share_btn.setEnabled(false);

        encrypt.setOnClickListener(v -> {
            String message_text = message.getText().toString();
            String key_text = key.getText().toString();
            if (message_text.isEmpty() || key_text.isEmpty()) {
                Toast.makeText(this, getString(R.string.message_or_key_is_empty), Toast.LENGTH_SHORT).show();
                ;
            } else {
                String message_handled_text = VigenereCipher.encrypt(message_text, key_text);
                message_handled.setText(message_handled_text);
                share_btn.setEnabled(true);
            }
        });

        decrypt.setOnClickListener(v -> {
            String message_text = message.getText().toString();
            String key_text = key.getText().toString();
            if (message_text.isEmpty() || key_text.isEmpty()) {
                Toast.makeText(this, getString(R.string.message_or_key_is_empty), Toast.LENGTH_SHORT).show();
                ;
            } else {
                String message_handled_text = VigenereCipher.decrypt(message_text, key_text);
                message_handled.setText(message_handled_text);
                share_btn.setEnabled(true);
            }
        });

        share_btn.setOnClickListener(v -> {
            String message_handled_text = message_handled.getText().toString();
            if (message_handled_text.isEmpty()) {
                Toast.makeText(this, getString(R.string.message_or_key_is_empty), Toast.LENGTH_SHORT).show();
            } else {
                // share the message handled to other apps
                share(message_handled_text);
            }
        });

    }


    public void share(String message) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_with)));
    }


    static class VigenereCipher {

        public static String encrypt(String message, String key) {
            StringBuilder result = new StringBuilder();
            int key_index = 0;
            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                if (Character.isLetter(c)) {
                    char key_c = key.charAt(key_index);
                    if (Character.isUpperCase(c)) {
                        result.append((char)((c - 'A' + key_c - 'A') % 26 + 'A'));
                    } else {
                        result.append((char)((c - 'a' + key_c - 'a') % 26 + 'a'));
                    }
                    key_index = (key_index + 1) % key.length();
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        }

        public static String decrypt(String message, String key) {
            StringBuilder result = new StringBuilder();
            int key_index = 0;
            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                if (Character.isLetter(c)) {
                    char key_c = key.charAt(key_index);
                    if (Character.isUpperCase(c)) {
                        result.append((char)((c - 'A' - key_c + 26) % 26 + 'A'));
                    } else {
                        result.append((char)((c - 'a' - key_c + 26) % 26 + 'a'));
                    }
                    key_index = (key_index + 1) % key.length();
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        }

    }

}