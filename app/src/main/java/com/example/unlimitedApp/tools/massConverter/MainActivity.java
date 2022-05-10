package com.example.unlimitedApp.tools.massConverter;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;

public class MainActivity extends BaseActivity {


    Spinner sp1, sp2;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_mass_converter_activity_main);
        ed1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        b1 = findViewById(R.id.btn1);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            setSupportActionBar(myToolbar);
        }
        String[] from = {"Ton", "Kg", "G", "Mg", "mmg", "Pond"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);

        String[] to = {"Ton", "Kg", "G", "Mg", "mmg", "Pond"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, to);
        sp2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tot;
                Double amount = Double.parseDouble(ed1.getText().toString());
                if (sp1.getSelectedItem().toString() == "Ton" && sp2.getSelectedItem().toString() == "Ton")
                {
                    tot = amount * 1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Ton" && sp2.getSelectedItem().toString() == "Kg")
                {
                    tot = amount * 1000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Ton" && sp2.getSelectedItem().toString() == "Mg")
                {
                    tot = amount * 1000000000000.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Ton" && sp2.getSelectedItem().toString() == "mmg")
                {
                    tot = amount * 1000000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Ton" && sp2.getSelectedItem().toString() == "Pond")
                {
                    tot = amount * 2.20462262;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Ton" && sp2.getSelectedItem().toString() == "G")
                {
                    tot = amount * 1000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }

                if (sp1.getSelectedItem().toString() == "Kg" && sp2.getSelectedItem().toString() == "Kg")
                {
                    tot = amount * 1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Kg" && sp2.getSelectedItem().toString() == "Ton")
                {
                    tot = amount /1000 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Kg" && sp2.getSelectedItem().toString() == "mmg")
                {
                    tot = amount * 1000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Kg" && sp2.getSelectedItem().toString() == "G")
                {
                    tot = amount * 1000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Kg" && sp2.getSelectedItem().toString() == "Mg")
                {
                    tot = amount * 1000000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Kg" && sp2.getSelectedItem().toString() == "Pond")
                {
                    tot = amount * 2.20462262;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "G" && sp2.getSelectedItem().toString() == "G")
                {
                    tot = amount * 1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "G" && sp2.getSelectedItem().toString() == "Ton")
                {
                    tot = amount /1000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "G" && sp2.getSelectedItem().toString() == "Kg")
                {
                    tot = amount /1000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "G" && sp2.getSelectedItem().toString() == "mmg")
                {
                    tot = amount * 1000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "G" && sp2.getSelectedItem().toString() == "Mg")
                {
                    tot = amount * 1000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "G" && sp2.getSelectedItem().toString() == "Pond")
                {
                    tot = amount * 0.00220462262;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "mmg" && sp2.getSelectedItem().toString() == "mmg")
                {
                    tot = amount * 1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "mmg" && sp2.getSelectedItem().toString() == "Ton")
                {
                    tot = amount * 1000000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "mmg" && sp2.getSelectedItem().toString() == "Kg")
                {
                    tot = amount / 1000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "mmg" && sp2.getSelectedItem().toString() == "Mg")
                {
                    tot = amount * 1000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "mmg" && sp2.getSelectedItem().toString() == "Pond")
                {
                    tot = amount /2.20462262 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "mmg" && sp2.getSelectedItem().toString() == "G")
                {
                    tot = amount / 1000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Mg" && sp2.getSelectedItem().toString() == "Mg")
                {
                    tot = amount * 1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Mg" && sp2.getSelectedItem().toString() == "Ton")
                {
                    tot = amount /1000000000000.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Mg" && sp2.getSelectedItem().toString() == "Kg")
                {
                    tot = amount / 1000000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Mg" && sp2.getSelectedItem().toString() == "G")
                {
                    tot = amount /1000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Mg" && sp2.getSelectedItem().toString() == "mmg")
                {
                    tot = amount / 1000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Mg" && sp2.getSelectedItem().toString() == "Pond")
                {
                    tot = amount /2.20462262;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Pond" && sp2.getSelectedItem().toString() == "Ton")
                {
                    tot = amount * 0.00045359237;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Pond" && sp2.getSelectedItem().toString() == "Kg")
                {
                    tot = amount * 0.45359237;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Pond" && sp2.getSelectedItem().toString() == "G")
                {
                    tot = amount * 453.59237;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Pond" && sp2.getSelectedItem().toString() == "mmg")
                {
                    tot = amount * 453592.37;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Pond" && sp2.getSelectedItem().toString() == "Mg")
                {
                    tot = amount * 453592370;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Pond" && sp2.getSelectedItem().toString() == "Pond")
                {
                    tot = amount * 1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}