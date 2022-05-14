package com.example.unlimitedApp.tools.randomPassword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;


public class MainActivity extends BaseActivity {

    Button reset,generate;
    EditText input_length;
    TextView output_password;
    int length = 8;
    CheckBox include_numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_random_password_activity_main);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle(getString(R.string.random_password_title));
            setSupportActionBar(myToolbar);
        }
        reset = (Button) findViewById(R.id.reset);
        generate =(Button) findViewById(R.id.generate);
        input_length = (EditText) findViewById(R.id.input_length);
        input_length.setText(length+"");
        output_password = (TextView) findViewById(R.id.output_password);
        include_numbers = (CheckBox) findViewById(R.id.include_numbers);

        reset.setOnClickListener(v -> {
            output_password.setText("");
            input_length.setText(length+"");
            include_numbers.setChecked(false);
        });

        generate.setOnClickListener(v -> {
            length = Integer.parseInt(input_length.getText().toString());

            if(length < 15 && length > 0){
                String ranString = generateRandomPassword();
                output_password.setText(getString(R.string.result)+ ranString);
                output_password.setVisibility(View.VISIBLE);
                Toast.makeText(v.getContext(), getString(R.string.copy_to_clipboard), Toast.LENGTH_SHORT).show();

                //copy text to clipboard
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("randomPassword", ranString);
                clipboard.setPrimaryClip(clip);

            }else{
                Toast.makeText(v.getContext(), getString(R.string.random_password_invalid_length), Toast.LENGTH_SHORT).show();
            }

        });

    }

    public String generateRandomPassword(){
        String password = "";
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for(int i = 0; i < length; i++){
            int index = (int) (Math.random() * chars.length());
            // random true of false
            boolean include_numbers_bool = Math.random() < 0.5;
            if(include_numbers_bool && include_numbers.isChecked()){
                password += generateRandomNumber();
            }else{
                password += chars.charAt(index);
            }
        }
        return password;
    }

    public String generateRandomNumber(){
        // generate random number
        int index = (int) (Math.random() * 10);
        return index+"";
    }

}