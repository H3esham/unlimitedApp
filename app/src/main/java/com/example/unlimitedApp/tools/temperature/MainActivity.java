package com.example.unlimitedApp.tools.temperature;


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
        setContentView(R.layout.tools_temperature_activity_main);
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            setSupportActionBar(myToolbar);
        }
        ed1 = findViewById(R.id.txtamount);
        sp1 = findViewById(R.id.spfrom);
        sp2 = findViewById(R.id.spto);
        b1 = findViewById(R.id.btn1);

        String[] from = {"C", "F", "K", "R","Re"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, from);
        sp1.setAdapter(ad);

        String[] to = {"C", "F","K", "R", "Re"};
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
                } else if (sp1.getSelectedItem().toString() == "C" && sp2.getSelectedItem().toString() == "F") {
                    tot = amount *33.8;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "C" && sp2.getSelectedItem().toString() == "K") {
                    tot = amount * 274.15;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "C" && sp2.getSelectedItem().toString() == "R") {
                    tot = amount * 493.47;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "C" && sp2.getSelectedItem().toString() == "Re") {
                    tot = amount /0.8 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "F" && sp2.getSelectedItem().toString() == "F") {
                    tot = amount *1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }

                if (sp1.getSelectedItem().toString() == "F" && sp2.getSelectedItem().toString() == "C") {
                    tot = amount / -17.2222222;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                } else if (sp1.getSelectedItem().toString() == "F" && sp2.getSelectedItem().toString() == "K") {
                    tot = amount *255.927778 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "F" && sp2.getSelectedItem().toString() == "R") {
                    tot = amount *460.67 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "F" && sp2.getSelectedItem().toString() == "Re") {
                    tot = amount / -13.7777778 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "K" && sp2.getSelectedItem().toString() == "K") {
                    tot = amount *1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "K" && sp2.getSelectedItem().toString() == "C") {
                    tot = amount / -272.15;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "K" && sp2.getSelectedItem().toString() == "F") {
                    tot = amount / -457.87 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "K" && sp2.getSelectedItem().toString() == "R") {
                    tot = amount *1.8 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "K" && sp2.getSelectedItem().toString() == "Re") {
                    tot = amount / -217.72 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "R" && sp2.getSelectedItem().toString() == "R") {
                    tot = amount *1.0 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "R" && sp2.getSelectedItem().toString() == "C") {
                    tot = amount / -272.594444 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "R" && sp2.getSelectedItem().toString() == "F") {
                    tot = amount / -458.67;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "R" && sp2.getSelectedItem().toString() == "K") {
                    tot = amount / 0.555555556 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "R" && sp2.getSelectedItem().toString() == "Re") {
                    tot = amount / -218.075556 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Re" && sp2.getSelectedItem().toString() == "C") {
                    tot = amount *1.25 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Re" && sp2.getSelectedItem().toString() == "F") {
                    tot = amount *34.25 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Re" && sp2.getSelectedItem().toString() == "K") {
                    tot = amount *274.4 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Re" && sp2.getSelectedItem().toString() == "R") {
                    tot = amount *493.92;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString() == "Re" && sp2.getSelectedItem().toString() == "Re") {
                    tot = amount *1.0 ;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}