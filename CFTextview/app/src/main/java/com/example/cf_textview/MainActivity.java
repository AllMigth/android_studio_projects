package com.example.cf_textview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtWelcome = (TextView) findViewById(R.id.txtWelcome);
        Toast.makeText(getApplicationContext(),"Text Actual" + txtWelcome.getText(), Toast.LENGTH_LONG).show();
        txtWelcome.setText("Adios");
        txtWelcome.setTextColor(Color.RED);
    }
}
