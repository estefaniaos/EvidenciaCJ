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
            System.out.println("Bienvenido al sistema");
            System.out.println("Ingresa tu nombre de usuario");
            username = write.next();
            System.out.println("Ingresa tu contraseña:");
            password = write.next();

            x.loadUsers();
            if(x.checkUser(username, password).inSession){
                System.out.println("Bienvenido al sistema " + username  );
                notLogged = false;
            }else {
                System.out.println("Credenciales incorrectas, vuelve a intentarlo");
            }
        }
    }
}

