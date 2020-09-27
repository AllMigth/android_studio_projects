package com.example.launchmode2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class A extends AppCompatActivity {
    Button btnA, btnB,btnC,btnD;
    TextView texMethod,txtLaunch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        texMethod = new StringBuilder();
        //Video componenets basicos TextView
        txtLaunch = (TextView) findViewById(R.id.txtLaunch);
        //Video componentes basico Button
        findViewById(R.id.btnA).setOnClickListener(this);
        findViewById(R.id.btnB).setOnClickListener(this);
        findViewById(R.id.btnC).setOnClickListener(this);
        findViewById(R.id.btnD).setOnClickListener(this);
        printMethod("onCreate");
    }
    @Override
    protected void onNewIntent(Intent intent){
            super.onNewIntent(intent);
            printMethod("onNewIntent");
    }
    //Ciclo de vida de un activity
    @Override
    protected void onPause(){
            super.onPause();
            printMethod("onPause");
    }
    @Override
    protected void onResume(){
            super.onResume();
            printMethod("onResume");
    }
    @Override
    protected void onDestroy(){
            super.onDestroy();
            printMethod("onDestroy");
    }
    //Video Componentes basicos button
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnA:
                openActivity(A.class);
                break;
            case R.id.btnB:
                openActivity(B.class);
                break;
            case R.id.btnC:
                openActivity(C.class);
                break;
            case R.id.btnD:
                openActivity(D.class);
                break;
        }
    }
    //video activity
    public void openActivity(Class C){startActivity();}


    private void printMethod(String method){
            textMethod.append(method).apped("\n");
            //Video TextView
            txtLaunch.setText(textMethod.toString());
        }

}
