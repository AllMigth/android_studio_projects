package com.example.cf_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView)findViewById(R.id.gridView);
        final AdapterStudent adapterStudent = new AdapterStudent(this, R.layout.item_adapter,Student.getStudents());
        //GRIDVIEW EXTIENDE DE ADAPTERVIEW, POR LO TANTO VAMOS A TENER EL METODO SET ADAPTER
        gridView.setAdapter(adapterStudent);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student student = adapterStudent.getItem(i);
                //de esta manera obtenemos el estudiante
                Toast.makeText(getApplicationContext(),"Alumno: "+student.getName(),Toast.LENGTH_LONG).show();
            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student student = adapterStudent.getItem(i);
                Toast.makeText(getApplicationContext(),"Alumno: "+student.getName(),Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
