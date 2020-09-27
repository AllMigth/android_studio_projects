package com.example.cf_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterStudent adapterStudent = new AdapterStudent(this,R.layout.item_adapter,Student.getStudents());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapterStudent);
    }
}
