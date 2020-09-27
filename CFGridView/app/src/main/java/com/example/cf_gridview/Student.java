package com.example.cf_gridview;

import java.util.ArrayList;

public class Student {
    //ATRIBUTOS
    private int id;
    private String name;
    private boolean isPass; //SI EL ALUMNO PASO si paso es true

    public Student(int id, String name, boolean isPass){
        /*CONSTRUCTOR DONDE PEDIMOS ID NOMBRE Y ISPASS
        * LO ASIGNAMOS EN VARIABLES LOCALES Y LO LLAMAMOS  CON THIS*/
        this.id=id;
        this.name=name;
        this.isPass=isPass;
    }
    //USAMOS GET PARA OBTENER LOS VALORES DE UN ALUMNO
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPass() {
        return isPass;
    }

    @Override
    public String toString(){
        return name;
    }

    public static ArrayList<Student> getStudents(){
        /*
        * METODO ESTATICO PARA PODERLO OBTENER DIRECTAMENTE DE LA CLASE
        * ARRAY LIST CREA UNA LISTA DE ESTUDIANTES
        * */

        ArrayList<Student> students=new ArrayList<>();
        students.add(new Student(1,"Marines",true));
        students.add(new Student(2,"Raquel",true));
        students.add(new Student(3,"Pedro",false));
        students.add(new Student(4,"Jose",true));
        return students;
    }
}
