package com.example.cf_include;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText txtAge;
    private ViewStub viewStub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewStub = (ViewStub)findViewById(R.id.viewStub);
        txtAge = (EditText)findViewById(R.id.txtAge);
    }

    public void validate(View view) {
        int age = Integer.parseInt(txtAge.getText().toString());
        if (age >= 18){
            View view1 = viewStub.inflate();
            Button btnWelcome = (Button) view1.findViewById(R.id.btnWelcome);
            btnWelcome.setText("Hola");
            btnWelcome.setBackgroundColor(Color.RED);
        }
    }
}
