package com.example.cf_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cf_adapter.AdapterStudent;
import com.example.cf_adapter.Student;

import java.util.ArrayList;

import static com.example.cf_adapter.Student.getStudents;


public class MainActivity extends AppCompatActivity {
    private ListView lvStudents;
    private ArrayList<Student>students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvStudents = (ListView)findViewById(R.id.lvStudents);

        final AdapterStudent adapterStudent = new AdapterStudent(this,R.layout.item_adapter,Student.getStudents());
        lvStudents.setAdapter(adapterStudent);
        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student student = adapterStudent.getItem(i);
                Toast.makeText(getApplicationContext(),"Nombre: "+student.getName(),Toast.LENGTH_LONG).show();
            }
        });
        lvStudents.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student student = adapterStudent.getItem(i);
                Toast.makeText(getApplicationContext(),"Nombre: "+student.getName(),Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
}
