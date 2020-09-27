package com.example.cf_viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewFlipper=findViewById(R.id.viewFlipper);
        //checando si el flipper esta en autoStart
        Toast.makeText(getApplicationContext(),"AutoStart: "+viewFlipper,Toast.LENGTH_LONG).show();
        //colocando intervalos
        viewFlipper.setFlipInterval(5000);
        //viewFlipper.setAutoStart(false);
        //autoStart solo se va a ejecutar al principio
        //tenemos en autoStart en el flipper del xml
    }

    public void next(View view) {
        viewFlipper.showNext();
        //haciendo que las vistas se detenga de cambiar solas
        viewFlipper.stopFlipping();
    }

    public void previous(View view) {
        viewFlipper.showPrevious();
        //haciendo que las vistas se cambien solas
        viewFlipper.startFlipping();
        Toast.makeText(getApplicationContext(),"AutoStart: "+viewFlipper.isFlipping(),Toast.LENGTH_LONG).show();
    }
}
