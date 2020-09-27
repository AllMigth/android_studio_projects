package com.example.cf_textswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    private TextSwitcher textSwitcher;
    private ImageSwitcher imageSwitcher;
    private int[] images={R.drawable.main,R.drawable.primero,R.drawable.segundo,R.drawable.tercero,R.drawable.cuarta};
    private String[] text = {"Main","Primero","Segundo","Tercero","Cuarto"};
    private  int position = 0; //contador para agregar las imagenes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher = findViewById(R.id.imageSwithcer);
        textSwitcher = findViewById(R.id.textSwithcer);
        next(null);
        //los textos los vamos a mostrar en el textSwitcher
        //creamos la fabrica para crear las vistas
        //Con set factory
        /*
        SUPONGAMOS QUE NO QUEREMOS CREAR LAS VISTAS DESDE ACA
        ENTONCES VAMOS AL XML Y LO HACEMOS ALLA

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //vamos a crear nuestra vista
                ImageView imageView = new ImageView(MainActivity.this);

                return imageView;
            }
        });

        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(MainActivity.this);
                return textView;
                //cargamos las dos vistas, la actual y la siguiente
            }
        });
        //de esta manera se ejecuta nuestro metodo sin hacer click
        next(null);
        //y se muestra la imagen
        */
    }

    public void next(View view) {
        textSwitcher.setText(text[position]);
        imageSwitcher.setImageResource(images[position]);//obtenemos la imagen
        position = (position+1)%images.length;
        /*no hacemos una comparacion, verificando que la posicion
        * sea menor a la cantidad de imagenes en nuestro arreglo*/
        //dividendo-(divisor X cociente)
        Toast.makeText(getApplicationContext(),"Vista"+imageSwitcher.getCurrentView().getId(),Toast.LENGTH_LONG).show();
    }
}
