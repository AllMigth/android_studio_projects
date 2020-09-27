package com.example.cf_chronometer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Chronometer chronometer;
    private long timePause; //agregar el tiempo recorrido en nuestro cronometro
    private boolean isStart; //variable para la validacion del boton start
    private boolean isPause; //variable para la validacion del boton pause
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = (Chronometer)findViewById(R.id.chronometer);
        findViewById(R.id.btnStart).setOnClickListener(this);
        findViewById(R.id.btnPause).setOnClickListener(this);
        findViewById(R.id.btnStop).setOnClickListener(this);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //este evento escucha mientras esta cambiando el tiempo en el cronometro
                long result = SystemClock.elapsedRealtime()-chronometer.getBase();
                //el resultado de esta resta seria el tiempo en milisegundos
                Toast.makeText(getApplicationContext(),"Time "+result,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStart:
                if (!isStart){
                    //iniciar el cronometro e iniciar tiempo base
                    chronometer.setBase(SystemClock.elapsedRealtime() - timePause);
                    //se agrega time pause para continuar el cronometro donde lo dejamos
                    Log.i("test start",SystemClock.elapsedRealtime()+" - "+timePause);
                    //vamos a obtener el resultado de esta resta
                    long result = SystemClock.elapsedRealtime() - timePause;
                    Log.i("test start",result+"");
                    //imprimimos por el Log (Logcat)
                    chronometer.start();
                    isStart=true;
                    isPause=false;
                }

                break;
            case R.id.btnPause:
                if (!isPause){
                    timePause = SystemClock.elapsedRealtime()-chronometer.getBase();
                    Log.i("test pause",SystemClock.elapsedRealtime()+" -- "+chronometer.getBase());
                    Log.i("test pause",timePause+"");
                    chronometer.stop();
                    isPause=true;
                    isStart=false;
                }
                break;
            case R.id.btnStop:
                if (isPause){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.stop();
                    timePause=0;
                    //cuando el usuario presione stop vamos a reiniciar el tiempo a 0
                }else{
                    Toast.makeText(getApplicationContext(),"Pausa el tiempo",Toast.LENGTH_LONG).show();
                }

                break;
        }
    }
}
