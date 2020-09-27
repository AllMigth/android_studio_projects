package com.example.cf_quickcontactbadge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.QuickContactBadge;

public class MainActivity extends AppCompatActivity {
    private QuickContactBadge email, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (QuickContactBadge)findViewById(R.id.email);
        phone = (QuickContactBadge)findViewById(R.id.phone);

        email.assignContactFromEmail("jgarzon292@gmail.com",true);
        phone.assignContactFromEmail("0123456789",true);
        /*Bundle bundle  = new Bundle();
        bundle.putString(ContactsContract.Intents.Insert.NAME,"Juan");
        LA LINEA DE ABAJO MARCA UN ERROR SI LA API ES MENOR A LA 18
        ENTONCES ARREGLAMOS ESO CON EL IF QUE COMPAARA LAS VERSIONES DE L SDK
        phone.assignContactFromPhone("0123456789",true, bundle);

        CON LA VERSION >18 PODEMOS ENVIAR MAS DATOS COMO NOMBRE, EMPRESA, ETC
        */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            Bundle bundle  = new Bundle();
            bundle.putString(ContactsContract.Intents.Insert.NAME,"Juan");
            phone.assignContactFromPhone("0123456789",true, bundle);
        }else { //sino solo enviamos el numero
            phone.assignContactFromPhone("0123456789",true);
        }
    }
}
