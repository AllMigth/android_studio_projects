package com.example.cf_searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = (SearchView)findViewById(R.id.searchView);
        CharSequence charSequence = searchView.getQuery();
        CharSequence hint = searchView.getQueryHint();

        //PARA OBTENER EL VALOR INGRESADO EN EL SEARCH VIEW
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //ESTE PRIMER METODO SE LLAMA CUANDO EL USUARIO ESTA ESCRIBIENDO EN LA CAJA DE TEXTO
                Toast.makeText(getApplicationContext(),"palabra "+s,Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            //ESTE SE EJECUTA CUANDO EL USUARIO PRESIONA LA TECLA ENTER PARA ENVIAR EL RESULTADO
            public boolean onQueryTextChange(String s) {
                Toast.makeText(getApplicationContext(),"palabra "+s,Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }
}
