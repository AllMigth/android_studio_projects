package com.example.tabhost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        newTab("tab1",R.id.tab1,"Alumnos",getIcon(R.drawable.mail));
        newTab("tab2",R.id.tab2,"Reprobados",getIcon(R.drawable.phone));
        newTab("tab3",R.id.tab3,"",getIcon(R.drawable.mail));
        //para establecer un tab seleccionado por defecto asignamos
        tabHost.setCurrentTab(2);
        /*PODEMOS USAR EL METODO SETONTABCHANGEDLISTENER PARA
        * SABER CUANDO EL USUARIO CAMBIA DE TAB*/
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                Toast.makeText(getApplicationContext(),"identificador "+s,Toast.LENGTH_LONG).show();
                //para saber la posicion podemos acceder al metodo .getCurrentTab()
                Toast.makeText(getApplicationContext(),"identificador "+tabHost.getCurrentTab(),Toast.LENGTH_LONG).show();
            }
        });
    }
    private Drawable getIcon(int idDrawable){
        //creamos un metodo porque existe una limitacion en el nivel de api
        return ContextCompat.getDrawable(getApplicationContext(),idDrawable);
    }
    /*VAMOS A CREAR LOS TABS JUNTO CON LAS PESTANAS*/
    private void newTab(String tag, int idContent, String title, Drawable drawable){
        //DENTRO DE NEWTABSPEC AGREGAMOS UN STRING
        TabHost.TabSpec spec = tabHost.newTabSpec(tag);
        //agregamos el contenido
        spec.setContent(idContent);
        //en el metodo set indicator podemos agregar un text o una imagen
        spec.setIndicator(title,drawable );
        tabHost.addTab(spec);
    }
}
