package com.example.cf_timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        setHour(16);
        setMinute(20);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Toast.makeText(getApplicationContext(),"hora: "+i+" minutos "+i1,Toast.LENGTH_LONG).show();
            }
        });
    }
    private int getHour() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return timePicker.getHour();
            //esto seria en un nivel de api >= 23
        }else{
            //esto seria en un nivel de api <= 22
            return timePicker.getCurrentHour();
        }
    }
    private void setHour(int hour){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker.setHour(hour);
        }else{
            timePicker.setCurrentHour(hour);
        }
    }
    private void setMinute(int minute) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker.setMinute(minute);
        }else{
            timePicker.setCurrentMinute(minute);
        }

    }
}
