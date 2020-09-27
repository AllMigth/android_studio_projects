package com.example.cf_viewswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ViewSwitcher viewSwitcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewSwitcher = findViewById(R.id.viewSwitcher);
        /*
        METODO PARA CREAR LAS VISTAS DESDE ACA
        TAMBIEN LO PODEMOS HACER DESDE XML

        viewSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //aqui creamos la vista y la retornamos
                //distinguimos la vista con getChildCount, regresa la cantidad de elementos 2 (0,1)
                TextView textView = new TextView(MainActivity.this);
                if (viewSwitcher.getChildCount()!=1){
                    textView.setText("Primera vista");
                }else {
                    textView.setText("Segunda vista");
                }
                    return textView;
            }
        }); */
        TextView textView = new TextView(MainActivity.this);
        textView.setText("Hola vista de addView");
        viewSwitcher.addView(textView);

        TextView textView2 = new TextView(MainActivity.this);
        textView2.setText("Hola vista 2 de addView");
        viewSwitcher.addView(textView2);
        //removiendo una vista desde un punto espefico
        //viewSwitcher.removeViewAt(1);
    }

    public void previous(View view) {
        viewSwitcher.showPrevious();
    }

    public void next(View view) {
        viewSwitcher.showPrevious();
    }
}
