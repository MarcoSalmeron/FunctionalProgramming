package org.example;

import org.example.Servicios.Serv_Persona;
import org.example.Servicios.Serv_Persona_Interface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Servicio con Base de datos logica//
        Serv_Persona_Interface servPersona = new Serv_Persona();

        Scanner leer = new Scanner(System.in);
        int opcion;

        do{
            System.out.println("\n-------MENU-------");
            System.out.println("1- Mostrar Personas");
            System.out.println("2- Filtrar Edades");
            System.out.println("3- Guardar Persona");
            System.out.println("0 -> SALIR");
            System.out.println("------------------");
            System.out.print("-elige: ");
            opcion = leer.nextInt();

            switch (opcion){
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    servPersona.getPersonas();
                    break;
                case 2:
                    servPersona.getPersonasMayores();
                    break;
                case 3:
                    servPersona.savePersona();
                    break;
                default:
                    System.out.println("Opcion Invalida!!!");
                    break;
            }
        } while (opcion != 0);
    }
}