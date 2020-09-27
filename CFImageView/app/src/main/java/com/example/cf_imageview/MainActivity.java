package com.example.cf_imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void image(View view) {
        //al dar click sobre el imageButton vamos a cambiar la imagen
        //de nuestro imageview
        imageView.setImageResource(R.drawable.cs);
        imageView.setScaleType((ImageView.ScaleType.FIT_XY));
    }
}
