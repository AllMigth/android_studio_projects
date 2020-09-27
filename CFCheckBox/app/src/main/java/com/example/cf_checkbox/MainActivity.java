package com.example.cf_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        if (checkBox.isChecked()){
            Toast.makeText(getApplicationContext(),"Seleccionado con if" + checkBox.getText(),Toast.LENGTH_LONG).show();
        }
        radioButton = (RadioButton)findViewById(R.id.radioButton);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(getApplicationContext(),"Seleccionado " + checkBox.getText(),Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(getApplicationContext()," No Seleccionado", LENGTH_LONG).show();
                }

            }
        });
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(getApplicationContext(),"Seleccionado " + radioButton.getText(), LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext()," No Seleccionado", LENGTH_LONG).show();
                }

            }
        });
    }
}
