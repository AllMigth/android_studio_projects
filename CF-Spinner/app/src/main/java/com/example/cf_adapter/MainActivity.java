package com.example.cf_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        /*ADAPTADOR SIMPLE
        ArrayAdapter<Student>adapter = new ArrayAdapter<Student>(this, R.layout.item_adapter, R.id.txtItem, Student.getStudents());
        //YA TENEMOS EL ADAPTADOR, TENEMOS QUE AGREGARLO AL ADAPTER VIEW QUE ES SPINNER
        //llamamos nuestro spinner
        spinner.setAdapter(adapter); //adapter es el adaptador simple
    */
        AdapterStudent adapter = new AdapterStudent(this, R.layout.item_adapter, Student.getStudents());
        /*adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        COMO YA TENEMOS UNA VISTA EN EL MENU NO ES NECESARIO AGREGALA
        EN ESTA PARTE
        */
        spinner.setAdapter(adapter);

    }
}
