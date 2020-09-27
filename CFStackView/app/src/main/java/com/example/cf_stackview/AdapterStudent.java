package com.example.cf_stackview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AdapterStudent extends ArrayAdapter {
    private Activity context;
    ArrayList<Student>students;
    private int resource;
    public AdapterStudent(@NonNull Activity context, int resource, ArrayList<Student>students) {
        //NO DECLARAMOS CONTEXT, SINO ACTIVITY PORQUE ELLA LO TRAE
        super(context, resource, students);
        /*TODO LO QUE RECIBAMOS EN EL CONSTRUCTOR LO TENEMOS QUE DECLARAR EN SUPER PARA
         *  QUE CARGUE DENTRO DEL ADAPTADOR studentes*/
        this.context = context;
        this.resource = resource;
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }
/*
    @Override
    public long getItemId(int i) {
        return 0;
    }*/

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();
        if(view==null){
            //SI NO ES NULLA SIGNIFICA QUE YA SE CREO UNA VISTA
            if(context!=null) {
                view = context.getLayoutInflater().inflate(resource, null);
                holder.txtItem = (TextView) view.findViewById(R.id.txtItem);
                holder.imageView=(ImageView)view.findViewById(R.id.imageView);
                view.setTag(holder); //VAMOS A TRANSPORTALO AL SIGUIENTE ITEM CON SETTAG
                //SETTAG NOS SIRVE PARA GUARDAR UN OBJETO

            }
        }else{
            holder = (ViewHolder)view.getTag();
        }
        Student student = students.get(i);
        holder.txtItem.setText(student.getName());
        if (!student.isPass()) {
            holder.txtItem.setBackgroundColor(Color.RED);
        }
        holder.imageView.setImageResource(student.getIdImage());
        return view;
    }
    static class ViewHolder{
        private  TextView txtItem;
        //dando de alta el imageView
        private ImageView imageView;
    }
}
