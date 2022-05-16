package com.example.unlimitedApp.tools.lenghtConverter;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.unlimitedApp.R;

public class MainActivity extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText ed1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pages_lenght_converter_activity_main);
        ed1=findViewById(R.id.txtamount);
        sp1=findViewById(R.id.spfrom);
        sp2=findViewById(R.id.spto);
        b1=findViewById(R.id.btn1);

        String[] from={"Km","m","cm","mm","n","in","ft","yard","Mk"};
        ArrayAdapter ad=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);

        String[] to={"Km","m","cm","mm","n","in","ft","yard","Mk"};
        ArrayAdapter ad1=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double tot;
                Double amount=Double.parseDouble(ed1.getText().toString());
                if(sp1.getSelectedItem().toString()=="m"&& sp2.getSelectedItem().toString()=="m"){
                    tot=amount*1.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="cm"&& sp2.getSelectedItem().toString()=="cm"){
                    tot=amount*1.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="mm"&& sp2.getSelectedItem().toString()=="mm"){
                    tot=amount*1.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="m"&& sp2.getSelectedItem().toString()=="cm"){
                    tot=amount*100;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="m"&& sp2.getSelectedItem().toString()=="mm"){
                    tot=amount*1000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="cm"&& sp2.getSelectedItem().toString()=="m"){
                    tot=amount/100;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="cm"&& sp2.getSelectedItem().toString()=="mm"){
                    tot=amount*10;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="mm"&& sp2.getSelectedItem().toString()=="m")
                {
                    tot=amount/1000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="mm"&& sp2.getSelectedItem().toString()=="cm")
                {

                    tot = amount / 10;
                    Toast.makeText(getApplicationContext(), tot.toString(), Toast.LENGTH_LONG).show();
                }
                if(sp1.getSelectedItem().toString()=="Km"&& sp2.getSelectedItem().toString()=="m")
                {
                    tot=amount*1000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="Km"&& sp2.getSelectedItem().toString()=="cm")
                {
                    tot=amount*100000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="Km"&& sp2.getSelectedItem().toString()=="mm")
                {
                    tot=amount*1000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="m"&& sp2.getSelectedItem().toString()=="Km")
                {
                    tot=amount/1000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="cm"&& sp2.getSelectedItem().toString()=="Km")
                {
                    tot=amount/100000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="cm"&& sp2.getSelectedItem().toString()=="Km")
                {
                    tot=amount/1000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="n"&& sp2.getSelectedItem().toString()=="n")
                {
                    tot=amount*1.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if(sp1.getSelectedItem().toString()=="Km"&& sp2.getSelectedItem().toString()=="n")
                {
                    tot=amount*1000000000000.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="m"&& sp2.getSelectedItem().toString()=="n")
                {
                    tot=amount*1000000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="cm"&& sp2.getSelectedItem().toString()=="n")
                {
                    tot=amount*10000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="mm"&& sp2.getSelectedItem().toString()=="n")
                {
                    tot=amount*1000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="n"&& sp2.getSelectedItem().toString()=="Km")
                {
                    tot=amount/1000000000000.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="n"&& sp2.getSelectedItem().toString()=="m")
                {
                    tot=amount/1000000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="n"&& sp2.getSelectedItem().toString()=="cm")
                {
                    tot=amount/10000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="n"&& sp2.getSelectedItem().toString()=="mm")
                {
                    tot=amount/1000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Km"&& sp2.getSelectedItem().toString()=="Km")
                {
                    tot=amount*1.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Km"&& sp2.getSelectedItem().toString()=="Mk")
                {
                    tot=amount*1000000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Km"&& sp2.getSelectedItem().toString()=="in")
                {
                    tot=amount*39370.0787 ;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Mk"&& sp2.getSelectedItem().toString()=="Mk")
                {
                    tot=amount*1.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Mk"&& sp2.getSelectedItem().toString()=="Km")
                {
                    tot=amount/1000000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Mk"&& sp2.getSelectedItem().toString()=="m")
                {
                    tot=amount/1000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Mk"&& sp2.getSelectedItem().toString()=="cm")
                {
                    tot=amount/10000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Mk"&& sp2.getSelectedItem().toString()=="mm")
                {
                    tot=amount/1000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Mk"&& sp2.getSelectedItem().toString()=="n")
                {
                    tot=amount*1000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Mk"&& sp2.getSelectedItem().toString()=="in")
                {
                    tot=amount/3.93701E-5;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Mk"&& sp2.getSelectedItem().toString()=="ft")
                {
                    tot=amount/3.2808398950131E-6;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Mk"&& sp2.getSelectedItem().toString()=="yard")
                {
                    tot=amount/1.0936132983377E-6;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Km"&& sp2.getSelectedItem().toString()=="yard")
                {
                    tot=amount*1093.6133;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="Km"&& sp2.getSelectedItem().toString()=="ft")
                {
                    tot=amount*3280.8399;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="m"&& sp2.getSelectedItem().toString()=="ft")
                {
                    tot=amount*3.2808399;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="m"&& sp2.getSelectedItem().toString()=="in")
                {
                    tot=amount*39.3700787;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="m"&& sp2.getSelectedItem().toString()=="yard")
                {
                    tot=amount*1.0936133;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="m"&& sp2.getSelectedItem().toString()=="Mk")
                {
                    tot=amount*1000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="cm"&& sp2.getSelectedItem().toString()=="Mk")
                {
                    tot=amount*10000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="cm"&& sp2.getSelectedItem().toString()=="yard")
                {
                    tot=amount*0.010936133;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="cm"&& sp2.getSelectedItem().toString()=="ft")
                {
                    tot=amount*0.032808399;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="cm"&& sp2.getSelectedItem().toString()=="in")
                {
                    tot=amount*.0393700787;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="mm"&& sp2.getSelectedItem().toString()=="Mk")
                {
                    tot=amount*1000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="mm"&& sp2.getSelectedItem().toString()=="yard")
                {
                    tot=amount*0.0010936133;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="mm"&& sp2.getSelectedItem().toString()=="ft")
                {
                    tot=amount*0.0032808399;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="mm"&& sp2.getSelectedItem().toString()=="in")
                {
                    tot=amount*0.0393700787;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="mm"&& sp2.getSelectedItem().toString()=="Km")
                {
                    tot=amount/1000000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="n"&& sp2.getSelectedItem().toString()=="Mk")
                {
                    tot=amount/1000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="n"&& sp2.getSelectedItem().toString()=="yard")
                {
                    tot=amount*1.0936133;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="n"&& sp2.getSelectedItem().toString()=="ft")
                {
                    tot=amount*3.2808399;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="n"&& sp2.getSelectedItem().toString()=="in")
                {
                    tot=amount*3.93700787;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="yard"&& sp2.getSelectedItem().toString()=="yard")
                {
                    tot=amount*1.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="yard"&& sp2.getSelectedItem().toString()=="Mk")
                {
                    tot=amount*914.400;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="yard"&& sp2.getSelectedItem().toString()=="Km")
                {
                    tot=amount*0.0009144;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="yard"&& sp2.getSelectedItem().toString()=="m")
                {
                    tot=amount*0.9144;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="yard"&& sp2.getSelectedItem().toString()=="cm")
                {
                    tot=amount*91.44;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="yard"&& sp2.getSelectedItem().toString()=="mm")
                {
                    tot=amount*914.4;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="yard"&& sp2.getSelectedItem().toString()=="n")
                {
                    tot=amount*914.400000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="yard"&& sp2.getSelectedItem().toString()=="ft")
                {
                    tot=amount*3;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="yard"&& sp2.getSelectedItem().toString()=="in")
                {
                    tot=amount*36;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="ft"&& sp2.getSelectedItem().toString()=="ft")
                {
                    tot=amount*1.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="ft"&& sp2.getSelectedItem().toString()=="Km")
                {
                    tot=amount*0.0003048;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="ft"&& sp2.getSelectedItem().toString()=="m")
                {
                    tot=amount*0.3048;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="ft"&& sp2.getSelectedItem().toString()=="cm")
                {
                    tot=amount*30.48;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="ft"&& sp2.getSelectedItem().toString()=="mm")
                {
                    tot=amount*304.8;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="ft"&& sp2.getSelectedItem().toString()=="Mk")
                {
                    tot=amount*304.800;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="ft"&& sp2.getSelectedItem().toString()=="n")
                {
                    tot=amount*304.800000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="ft"&& sp2.getSelectedItem().toString()=="yard")
                {
                    tot=amount*0.333333333;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="ft"&& sp2.getSelectedItem().toString()=="in")
                {
                    tot=amount*12;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="in"&& sp2.getSelectedItem().toString()=="in")
                {
                    tot=amount*1.0;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="in"&& sp2.getSelectedItem().toString()=="Km")
                {
                    tot=amount/2.5400000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="in"&& sp2.getSelectedItem().toString()=="m")
                {
                    tot=amount*0.0254;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="in"&& sp2.getSelectedItem().toString()=="cm")
                {
                    tot=amount*2.54;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="in"&& sp2.getSelectedItem().toString()=="mm")
                {
                    tot=amount*25.4;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="in"&& sp2.getSelectedItem().toString()=="Mk")
                {
                    tot=amount*25.400;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="in"&& sp2.getSelectedItem().toString()=="n")
                {
                    tot=amount*25.400000;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="in"&& sp2.getSelectedItem().toString()=="yard")
                {
                    tot=amount*0.0277777778;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }
                else if (sp1.getSelectedItem().toString()=="in"&& sp2.getSelectedItem().toString()=="ft")
                {
                    tot=amount*0.0833333333;
                    Toast.makeText(getApplicationContext(),tot.toString(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}