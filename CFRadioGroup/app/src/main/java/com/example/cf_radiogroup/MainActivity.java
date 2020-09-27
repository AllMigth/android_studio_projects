package com.example.cf_radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=(RadioGroup)findViewById(R.id.rg);
        txtResult=(TextView)findViewById(R.id.txtResult);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton)findViewById(i);
                // i es el id del radiobutton
                txtResult.setText(radioButton.getText());
            }
        });
        /*QUE PASA SI QUIERO OBTENER EL RADIO BUTTON SELECCIONADO, EN OTRO METODO*/
        RadioButton radioButton = (RadioButton)findViewById(radioGroup.getCheckedRadioButtonId());
        Toast.makeText(getApplicationContext(),"Opcion "+radioButton.getText(),Toast.LENGTH_LONG).show();
    }
}
