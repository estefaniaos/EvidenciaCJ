package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    HashMap<String, String[]> doctors = new HashMap<>();
    HashMap<String, String[]> pacientes = new HashMap<>();
    String filename;
    BufferedWriter bufferedWriter = null;

    private static final int doctor = 0;
    private static final int paciente = 1;

    public void Database(){
        this.filename = "";
    }

    public String getItemId(int type){
        String newId;
        int auxId;

        if(type == doctor){
            this.filename = "db/doctors.txt";
            newId = load(filename);

            if(newId.equals("")){
                newId = "0";
            }

            auxId = Integer.parseInt(newId);
            auxId++;
            newId = String.valueOf(auxId);
        }else{
            newId = "";
        }

        return newId;
    }

    public void addItem(int type, String id, String[] info){
        if(type == doctor){
            doctors.put(id, info);
            save();
        }
    }

    public String load(String filename){
        BufferedReader bufferedReader = null;
        String lastId = "";

        try {
            bufferedReader = new BufferedReader(new FileReader(filename));

            String line, id, name, lastName, specialty;
            String[] info = new String[3];

            while ((line = bufferedReader.readLine()) != null) {

                String[] res = line.split("[,]", 0);
                id = res[0];
                name = res[1];
                lastName = res[2];
                specialty = res[3];

                info[0] = name;
                info[1] = lastName;

                if(filename == "db/doctors.txt"){
                    info[2] = specialty;
                    doctors.put(id, info);
                    lastId = id;
                }else{
                    pacientes.put(id, info);
                    lastId = id;
                }

            }
        } catch(IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }

        return lastId;
    }

    public void save(){

        try {
            this.bufferedWriter = new BufferedWriter(new FileWriter(this.filename));

            this.doctors.entrySet().forEach(entry->{
                String line;
                line = entry.getKey() + ",";
                for (int i = 0; i < entry.getValue().length; i++) {
                    line = line + entry.getValue()[i];
                    if(i != entry.getValue().length-1){
                        line = line + ",";
                    }
                }
                System.out.println(line);
                try {
                    this.bufferedWriter.write(line + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch(IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (this.bufferedWriter != null) {
                    this.bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }
}
