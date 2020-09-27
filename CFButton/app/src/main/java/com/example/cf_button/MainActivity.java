package com.example.cf_button;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnCancel;
    private Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCancel = (Button)findViewById(R.id.btnCancel);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btnCancel.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCancel:
                Toast.makeText(getApplicationContext(),"Cancelar",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnGuardar:
                Toast.makeText(getApplicationContext(),"Guardar",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
