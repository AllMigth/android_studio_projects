package com.example.cf_orientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"OnCreate",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        /*FUNCIONARIA COMO SEGUNDA ACTIVIDAD
        * EL QUE VA A RECIBIR LOS DATOS
        * CON ESTE METODO VAMOS A RECIBIR LOS DATOS Y LOS VAMOS A RESTAURAR
        * se ejecuta despues de onStart*/
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(),"Nombre "+savedInstanceState.getString("name",""),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        /*onSaveInstanceState
        * NOS SIRVE PARA RESPALDAR LOS DATOS OSEA GUARDARLOS
        * SERIA COMO LA ACTIVIDAD NUMERO 1 QUE VA A ENVIAR LOS DATOS
        * #############
        * SE EJECUTA ANTES DE ONSTOP Y DESTROY VAMOS A RESPALDAR LOS DATOS
        * */
        super.onSaveInstanceState(outState);
        outState.putString("name","Juan");//ESTE ES EL DATO RESPALDADO
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"OnDestroy",Toast.LENGTH_LONG).show();
    }
}
