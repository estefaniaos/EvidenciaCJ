package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner write = new Scanner(System.in);

        login(write);

    }

    public static void login(Scanner write){
        String username, password;
        boolean notLogged = true;

        Login x = new Login();

        while (notLogged){
            System.out.println("======================================");
            System.out.println("Bienvenido al sistema");
            System.out.println("======================================");
            System.out.println("Ingresa tu nombre de usuario");
            username = write.next();
            System.out.println("Ingresa tu contraseña:");
            password = write.next();

            x.loadUsers();
            if(x.checkUser(username, password).inSession){
                System.out.println("======================================");
                System.out.println("Bienvenido al sistema " + username  );
                System.out.println("======================================");
                notLogged = false;
                showMenu(write);
            }else {
                System.out.println("Credenciales incorrectas, vuelve a intentarlo");
            }
        }
    }

    public static void showMenu(Scanner write){
        boolean actMenu = true;
        String x, nombre, apellido, especialidad;

        while (actMenu){
            System.out.println("Ingresa el número de opción que desees realizar");
            System.out.println("a) Agregar a un doctor    b) Dar de alta a un paciente     c) Crear una cita     d) Salir");
            x = write.next();

            switch (x){
                case "a":
                    Doctor doc = new Doctor();
                    System.out.println("Ingresa el nombre del doctor");
                    nombre = write.next();
                    System.out.println("Ingresa el apellido del doctor");
                    apellido = write.next();
                    System.out.println("Ingresa la especialidad del doctor");
                    especialidad = write.next();

                    doc.addDoctor(nombre, apellido, especialidad);
                    System.out.println("El doctor " + nombre + " " + apellido + " fue creado exitosamente");
                    break;
                case "d":
                    System.out.println("Gracias por utilizar el sistema, ¡adiós!");
                    actMenu = false;
                    break;
                default:
                    System.out.println("Ingresa un valor válido por favor");
                    break;
            }
        }

    }
}

