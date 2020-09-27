package com.example.cf_datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private long dateMillis = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = (DatePicker)findViewById(R.id.datePicker);
        Toast.makeText(getApplicationContext(),"Month "+datePicker.getMonth(),Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Year "+datePicker.getYear(),Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Dia "+datePicker.getDayOfMonth(),Toast.LENGTH_LONG).show();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date = simpleDateFormat.parse("2020/11/10");
            dateMillis = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //datePicker.setMaxDate(dateMillis);
        datePicker.init(2017, 11, 15, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(),"Year" + i+ " Month "+i1+" Day "+i2,Toast.LENGTH_LONG);
            }
        });

    }
}
