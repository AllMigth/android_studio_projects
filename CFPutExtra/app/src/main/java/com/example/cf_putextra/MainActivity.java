package com.example.cf_putextra;
 /**
  * DEV: JUAN GARZON
  * TAREA DE LA APP:
  * ENVIAR DATOS DESDE ELLA A OTRA APLICACION
  * INSTALADA EN NUESTRO TELEFONO
 * */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShow = (Button)findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("age",23);
                intent.putExtra("welcome","Juan");
                intent.putExtra("relaxed",true);
                startActivity(intent);
                INTENT EXPLICITO
                */
                //INTENT IMPLICITO
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"MI PRIMER MENSAJE DESDE MI APP ANDROID A OTRA APP DEL SISTEA"); //IGUAL ACA ACAMBIAS EL VALOR
                //intent.setType("image/jpg");  PARA ENVIAR UNA IMAGEN
                intent.setType("text/plain");
                startActivity(intent.createChooser(intent, "Envia el texto a: "));

            }
        });
    }
}
