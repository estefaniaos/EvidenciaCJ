package com.company;

public class Doctor {

    private static final int doctor = 0;

    String id;
    String nombre;
    String apellido;
    String especialidad;

    public void Doctor(){
        this.id = "";
        this.nombre = "";
        this.apellido = "";
        this.especialidad = "";
    }

    public void addDoctor(String name, String lastName, String specialty){
        String[] info = new String[3];

        this.nombre = name;
        this.apellido = lastName;
        this.especialidad = specialty;

        Database x = new Database();
        this.id = (x.getItemId(doctor));

        info[0] = this.nombre;
        info[1] = this.apellido;
        info[2] = this.especialidad;

        x.addItem(doctor, this.id, info);


    }
}
