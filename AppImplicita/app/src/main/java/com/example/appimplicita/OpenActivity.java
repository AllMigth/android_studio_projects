package com.example.appimplicita;
/**
 * ESTA APLICACION VA A RECIBIR DATOS DESDE OTRA APLICACION
 * EN EL MISMO DISPOSITIVO
 * */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;

public class OpenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            Toast.makeText(getApplicationContext(),"Mensaje "+bundle.getString(Intent.EXTRA_TEXT),Toast.LENGTH_LONG).show();
            //ASI RECIBIMOS EL TEXTO DESDE OTRAS APLICACIONES

        }
    }
}
