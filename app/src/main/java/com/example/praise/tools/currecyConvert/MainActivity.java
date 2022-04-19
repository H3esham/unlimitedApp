package com.example.praise.tools.currecyConvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

import com.example.praise.R;

public class MainActivity extends AppCompatActivity {
    Spinner sp1,sp2;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_currecy_convert_activity_main);
        ed1=findViewById(R.id.txtamount);
        sp1=findViewById(R.id.spfrom);
        sp2=findViewById(R.id.spto);
        b1=findViewById(R.id.btn1);

        String[] from={"USD","BTC"};
        ArrayAdapter ad=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String[] to={"EGY","EUR","GBP","AED","INR","TRY","JPY","KWD","USD"};
        ArrayAdapter ad1=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tot;
                Double amount=Double.parseDouble(ed1.getText().toString());
                if(sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="EGY"){
                    tot=amount*18.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="INR"){
                    tot=amount*76.18;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="EUR"){
                    tot=amount*0.92;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="GBP"){
                    tot=amount*0.76;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="AED"){
                    tot=amount*3.6;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="TRY"){
                    tot=amount*14.63;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="JPY"){
                    tot=amount*126.46;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="KWD")
                {
                    tot=amount*0.30;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="USD"&& sp2.getSelectedItem().toString()=="USD")
                {

                    tot = amount * 1.0;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                if(sp1.getSelectedItem().toString()=="BTC"&& sp2.getSelectedItem().toString()=="USD")
                {
                    tot=amount*40445.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="BTC"&& sp2.getSelectedItem().toString()=="EGP")
                {
                    tot=amount*745559.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="BTC"&& sp2.getSelectedItem().toString()=="GBP")
                {
                    tot=amount*37344.3;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="BTC"&& sp2.getSelectedItem().toString()=="AED")
                {
                    tot=amount*148307.66;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="BTC"&& sp2.getSelectedItem().toString()=="TNR")
                {
                    tot=amount*3079415.21;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="BTC"&& sp2.getSelectedItem().toString()=="TRY")
                {
                    tot=amount*590454.29;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="BTC"&& sp2.getSelectedItem().toString()=="JPY")
                {
                    tot=amount*5100736.80;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="BTC"&& sp2.getSelectedItem().toString()=="KWD")
                {
                    tot=amount*12316.60;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="BTC"&& sp2.getSelectedItem().toString()=="EUR")
                {
                    tot=amount*30890.20;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}