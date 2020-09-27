package com.example.cf_putextra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = getIntent().getExtras();
        /*
        el bundle se encarga de almacenar lo enviado desde la otra
        actividad
        * */
        if(bundle!=null){
            String welcome = bundle.getString("welcome");
            int age = bundle.getInt("age",0);
            boolean relaxed = bundle.getBoolean("relaxed",false);
            Toast.makeText(getApplicationContext(), "Welome "+ welcome + " age "+ age+" Relaxed "+relaxed, Toast.LENGTH_LONG).show();

        }
    }
}
