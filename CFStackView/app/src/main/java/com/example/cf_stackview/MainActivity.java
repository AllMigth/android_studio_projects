package com.example.cf_stackview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.StackView;

public class MainActivity extends AppCompatActivity {
    private StackView stackView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //stackView hereda de adpater view, por lo que nos encontraremos con el metodo set adapter
        stackView = findViewById(R.id.stackView);
        AdapterStudent adapterStudent = new AdapterStudent(this,R.layout.item_adapter,Student.getStudents());
        stackView.setAdapter(adapterStudent);
    }
    public void next(View view) {
        stackView.showNext();
    }

    public void previous(View view) {
        stackView.showPrevious();
    }
}
