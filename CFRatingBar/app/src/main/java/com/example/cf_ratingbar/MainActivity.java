package com.example.cf_ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtRating;
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TEXT VIEW DONDE SE VA A MOSTRAR LA CALIFICACION
        txtRating = (TextView)findViewById(R.id.txtRating);
        //RATING BAR DONDE EL USUARIO PODRA MANIPULAR LA CALIFICACION
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);

        /*EVENTO DE RATING BAR PARA OBTENER LA CALIFICACION QUE
        EL USUARIO VA COLOCANDO   *
        */
        ratingBar.setRating(2.5f); //hace referencia a float el tipo f
        ratingBar.setIsIndicator(true);
        txtRating.setText(ratingBar.getRating()+"");
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
               /*ratingbar actual
                float = calificacion del usuario porque puede ser 1.5
                y depende lo que coloquemos en stepside
                boolean = retorna si el usuario presiono el rating bar true o false
                * */
               txtRating.setText(v + "");
               /*RETORNA UN VALOR FLOTANDO, VAMOS A CONCATENAR PARA QUE NO
               * NOS MARQUE ERROR*/
            }
        });
    }
}
