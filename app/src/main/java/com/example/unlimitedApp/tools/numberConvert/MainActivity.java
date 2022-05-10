package com.example.unlimitedApp.tools.numberConvert;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;

public class MainActivity extends BaseActivity {
    private EditText editTextDecimal;
    private EditText editTextBinary;
    private EditText editTextOctal;
    private EditText editTextHexa;
    private Button buttonClear;
    private String value;
    private View.OnFocusChangeListener onFocusChangeListener;
    private int focusViewId;
    private GradientDrawable gradientDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tool_number_convert_activity_main);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            setSupportActionBar(myToolbar);
        }
        editTextDecimal = findViewById(R.id.etvDecimal);
        editTextBinary = findViewById(R.id.etvBinary);
        editTextOctal = findViewById(R.id.etvOctal);
        editTextHexa = findViewById(R.id.etvHexa);
        buttonClear = findViewById(R.id.btnClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearField();
            }
        });

        editTextDecimal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                value = editTextDecimal.getText().toString().trim();
                if (value.length() > 0) {
                    convertNumber();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
        onFocusChangeListener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                //Toast.makeText(getApplicationContext(),"FOCUS IN",Toast.LENGTH_SHORT).show();
                focusViewId = view.getId();
                GradientDrawable gradientDrawable = new GradientDrawable(
                        GradientDrawable.Orientation.TR_BL,
                        new int[]{Color.parseColor("#CCCC30"), Color.parseColor("#EC8282")}
                );
                gradientDrawable.setShape(GradientDrawable.RECTANGLE);
                gradientDrawable.setCornerRadius(10);
                if (focusViewId == R.id.etvDecimal) {
                    gradientDrawable.setStroke(8, ContextCompat.getColor(getApplicationContext(), android.R.color.holo_green_light));
                } else {
                    gradientDrawable.setStroke(8,
                            ContextCompat.getColor(getApplicationContext(),
                                    android.R.color.holo_green_light));


                    view.setBackground(gradientDrawable);
                }
            }
        };
        editTextDecimal.setOnFocusChangeListener(onFocusChangeListener);
        editTextBinary.setOnFocusChangeListener(onFocusChangeListener);
        editTextOctal.setOnFocusChangeListener(onFocusChangeListener);
        editTextHexa.setOnFocusChangeListener(onFocusChangeListener);
    }
    private void clearField() {
        editTextDecimal.setText("");
        editTextBinary.setText("");
        editTextOctal.setText("");
        editTextHexa.setText("");

    }

    private void convertNumber() {
        try{
            long num =Long.parseLong(value);
            editTextBinary.setText(String.valueOf(Long.toBinaryString(num)));
            editTextOctal.setText(String.valueOf(Long.toOctalString(num)));
            editTextHexa.setText(String.valueOf(Long.toHexString(num)));
        }catch (NumberFormatException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}