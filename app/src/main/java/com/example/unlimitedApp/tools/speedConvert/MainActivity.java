package com.example.unlimitedApp.tools.speedConvert;


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
        setContentView(R.layout.tools_speed_convert_activity_main);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            setSupportActionBar(myToolbar);
        }
        ed1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        b1 = findViewById(R.id.btn1);

        String[] from = {"C", "m/s", "Km/h", "Km/s"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);

        String[] to = {"C", "m/s", "Km/h", "Km/s"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, to);
        sp2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tot;
                Double amount = Double.parseDouble(ed1.getText().toString());
                if (sp1.getSelectedItem().toString() == "C" && sp2.getSelectedItem().toString() == "C") {
                    tot = amount * 1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "C" && sp2.getSelectedItem().toString() == "m/s") {
                    tot = amount * 299.792458;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "C" && sp2.getSelectedItem().toString() == "Km/h") {
                    tot = amount * 1.07925285000000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "C" && sp2.getSelectedItem().toString() == "Km/s") {
                    tot = amount * 299792.458;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "m/s" && sp2.getSelectedItem().toString() == "m/s") {
                    tot = amount * 1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "m/s" && sp2.getSelectedItem().toString() == "C") {
                    tot = amount /3.33564095000000000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }

                if (sp1.getSelectedItem().toString() == "m/s" && sp2.getSelectedItem().toString() == "Km/h") {
                    tot = amount * 3.6;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "m/s" && sp2.getSelectedItem().toString() == "Km/s") {
                    tot = amount /0.001 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Km/h" && sp2.getSelectedItem().toString() == "Km/h") {
                    tot = amount *1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Km/h" && sp2.getSelectedItem().toString() == "C") {
                    tot = amount /9.265669310000000000 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Km/h" && sp2.getSelectedItem().toString() == "m/s") {
                    tot = amount /0.277777778 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Km/h" && sp2.getSelectedItem().toString() == "Km/s") {
                    tot = amount /0.000277777778 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Km/s" && sp2.getSelectedItem().toString() == "Km/s") {
                    tot = amount /1.0 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Km/s" && sp2.getSelectedItem().toString() == "C") {
                    tot = amount /3.33564095000000 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Km/s" && sp2.getSelectedItem().toString() == "m/s") {
                    tot = amount *1000;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Km/s" && sp2.getSelectedItem().toString() == "Km/h") {
                    tot = amount *3.600 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}