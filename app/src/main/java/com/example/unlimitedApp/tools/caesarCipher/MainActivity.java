package com.example.unlimitedApp.tools.caesarCipher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;

import static com.example.unlimitedApp.tools.caesarCipher.Utility.decrypt1;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends BaseActivity {
    private Button encrypt,decrypt;
    private EditText message,cipher,key;
    private TextView screenOutput;
    private static final String ALPHABETSTRING="abcdefghijklmnopqrstuvwxyz";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_caesar_cipher_activity_main);

        encrypt = findViewById(R.id.btnEncrypt);
        decrypt = findViewById(R.id.btnDecrypt);
        screenOutput =findViewById(R.id.tV1);


        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);

            setSupportActionBar(myToolbar);
        }
        
        message = findViewById(R.id.inputMessage);
        cipher =  findViewById(R.id.ciphEdt);
        key = findViewById(R.id.keyDt);
        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encrypt12(message.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });
        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrypt12(cipher.getText().toString(),Integer.parseInt(key.getText().toString()));
            }
        });
    }
    public void decrypt12(String cipher,int key){
        screenOutput.setText(decrypt1(cipher,key).toLowerCase());
    }
    public String encrypt12 (String message,int shiftKey){
        message =message .toLowerCase();
        String cipherText ="";
        for (int i=0;i<message.length();i++){
            int charPosition =ALPHABETSTRING.indexOf(message.charAt(i));
            int keyVal =(shiftKey+charPosition)%26;
            char replaceVAL=ALPHABETSTRING.charAt(keyVal);
            cipherText+=replaceVAL;
            screenOutput.setText(cipherText);
            cipher.setText(cipherText);
        }
        return cipherText;
    }


}