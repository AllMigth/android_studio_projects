package com.example.cf_glide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        Glide.with(this).load("https://i.ibb.co/9NWDq2k/shawarma.png")
                .placeholder(R.drawable.image)
                .error(R.drawable.image)
                .override(900,900)
                .into(imageView);
    }
}
