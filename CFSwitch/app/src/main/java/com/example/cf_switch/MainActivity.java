package com.example.cf_switch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch=(Switch)findViewById(R.id.aSwitch);
        //ESTO DETECTA CUANDO CAMBIEMOS DE UNA OPCION A OTRA
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            /*
            * NOS RETORNA EN QUE ESTADO ESTA FALSE O TRUE*/
            if(b){
                Toast.makeText(getApplicationContext(),"On",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"Off",Toast.LENGTH_LONG).show();
            }
            }
        });
    }
}
