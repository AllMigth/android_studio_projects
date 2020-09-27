package com.example.cf_adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

    /*CUALQUIER COSA QUE QUERAMOS HACER EN EL ITEM SELECCIONAD
    * LO VAMOS A HACER EN ESTA PARTE*/
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();
        if(view==null){
            //SI NO ES NULLA SIGNIFICA QUE YA SE CREO UNA VISTA
            if(context!=null) {
                view = context.getLayoutInflater().inflate(resource, null);
                holder.txtItem = (TextView) view.findViewById(R.id.txtItem);
                view.setTag(holder); //VAMOS A TRANSPORTALO AL SIGUIENTE ITEM CON SETTAG
                //SETTAG NOS SIRVE PARA GUARDAR UN OBJETO
            }
        }else{
            holder = (ViewHolder)view.getTag();
        }
        Student student = students.get(i);
        holder.txtItem.setBackgroundColor(Color.YELLOW);
        holder.txtItem.setText(student.getName());
        if (!student.isPass()) {
            holder.txtItem.setBackgroundColor(Color.RED);
        }
        return view;
    }

    /*CUALQUIER COSA QUE QUERAMOS PERSONALIZAR EN EL MENU LOS HAREMOS EN ESTA
    * PARTE*/
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        if(convertView==null){
            //SI NO ES NULLA SIGNIFICA QUE YA SE CREO UNA VISTA
            if(context!=null) {
                convertView = context.getLayoutInflater().inflate(resource, null);
                holder.txtItem = (TextView) convertView.findViewById(R.id.txtItem);
                convertView.setTag(holder); //VAMOS A TRANSPORTALO AL SIGUIENTE ITEM CON SETTAG
                //SETTAG NOS SIRVE PARA GUARDAR UN OBJETO
            }
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        Student student = students.get(position);
        holder.txtItem.setText(student.getName());
        if (!student.isPass()) {
            holder.txtItem.setBackgroundColor(Color.RED);
        }
        return convertView;

    }

    static class ViewHolder{
        private  TextView txtItem;
    }
}
