package com.example.unlimitedApp.tools.calculatAge;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import com.example.unlimitedApp.R;
import com.example.unlimitedApp.utility.BaseActivity;

public class MainActivity extends BaseActivity {
    Button btBirth,btToday,btCalculate;
    TextView tvResult;
    DatePickerDialog.OnDateSetListener dateSetListener1,dateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_calculat_age_activity_main);
        // toolbar
        if (findViewById(R.id.Toolbar) != null) {
            myToolbar = (Toolbar) findViewById(R.id.Toolbar);
            myToolbar.setTitle(getString(R.string.calculat_age_title));
            setSupportActionBar(myToolbar);
        }

        btBirth =findViewById(R.id.bt_birth);
        btToday =findViewById(R.id.bt_today);
        btCalculate =findViewById(R.id.bt_calculate);
        tvResult =findViewById(R.id.tv_result);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("dd/MM/yyyy");
        String date =simpleDateFormat.format(Calendar.getInstance().getTime());
        btToday.setText(date);

        btBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(
                        MainActivity.this
                        , android.R.style.Theme_Holo_Dialog_MinWidth
                        ,dateSetListener1,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new
                        ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        dateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month =month +1;
                String date =day +"/"+month+"/"+year;
                btBirth.setText(date);
            }
        };

        btToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(
                        MainActivity.this
                        , android.R.style.Theme_Holo_Dialog_MinWidth
                        ,dateSetListener2,year,month,day
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new
                        ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month =month +1;
                String date =day +"/"+month+"/"+year;
                btToday.setText(date);
            }
        };
        btCalculate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String sDate = btBirth .getText().toString();
                String eDate = btToday .getText().toString();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");


                try {
                    Date date1 =simpleDateFormat1.parse(eDate);
                    Date date2 =simpleDateFormat1.parse(sDate);
                    long startDate = date1.getTime();
                    long endDate = date2.getTime();
                    if (startDate <= endDate){
                        Period period =new Period(startDate,endDate,PeriodType.yearMonthDay());
                        int years = period.getYears();
                        int months = period.getMonths();
                        int days = period.getDays();
                        tvResult.setText(years+"Years |"+months+" Months |"+days+" Days |");
                    }else{
                        Toast.makeText(getApplicationContext()
                                ,"Birth Date should not be larger than today's date.",
                                Toast.LENGTH_SHORT).show();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }


            }
        });
    }
}