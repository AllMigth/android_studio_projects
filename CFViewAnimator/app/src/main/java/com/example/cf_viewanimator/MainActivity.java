package com.example.cf_viewanimator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ViewAnimator viewAnimator;
    private EditText txtMessage, txtName;
    private TextView txtResult, txtSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewAnimator = findViewById(R.id.viewAnimator);
        txtMessage = findViewById(R.id.txtMessage);
        txtName = findViewById(R.id.txtName);
        txtResult = findViewById(R.id.txtResult);
        txtSend = findViewById(R.id.txtSend);
        //cambiando las animaciones desde aqui
        viewAnimator.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));
        viewAnimator.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_out_right));
        //creando una nueva vista
        TextView textView = new TextView(this);
        textView.setText("Bienvenido");
        viewAnimator.removeViewAt(1); //removiendo por indice
        viewAnimator.addView(textView,1); //agregando por indice
    }
    public void next(View view){
            //obtener la vista actual
            if (viewAnimator.getCurrentView().getId()!= R.id.three){
                //validacion or si el usuario no lleno los campos
                String name = txtName.getText().toString();
                String message = txtMessage.getText().toString();
                if (!name.equals("") && !message.equals("")){
                    //pasamos de una vista a otra a traves del metodo show next
                    viewAnimator.showNext();
                    //pasando datos de una vista a otra
                    txtResult.setText("Tu mensaje es este "+message);
                    txtSend.setText("Felicidades "+name+" tu mensaje se envio");
                }else{
                    Toast.makeText(getApplicationContext(),"Llenar los campos",Toast.LENGTH_LONG).show();
                }
            }


    }
    public void previous(View view){
        //validacion or si el usuario no lleno los campos
        if (viewAnimator.getCurrentView().getId()!= R.id.one){
            viewAnimator.showPrevious();
        }
    }

}
