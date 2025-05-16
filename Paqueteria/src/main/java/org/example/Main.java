package org.example;

import org.example.Modelos.Cliente;
import org.example.Repositorios.BaseDatos;
import org.example.Repositorios.Repo_Cliente;
import org.example.Servicios.ServicioCliente;
import org.example.Servicios.Servicio_Cliente_Interface;

import javax.swing.*;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         *
         * Paqueteria que almacena datos de clientes para nuevos Envios
         *
         * clientes -> nro_cliente, nombre, apellido, direccion, telefono
         * (Antes la app no obligaba la direccion, evaluar campo antes de hacer envio)
         *
         * Hay clientes que poseen el campo de direccion como null,
         * al buscar la direccion para un envio da error al no existir
         *
         * Informar al Usuario que el campo esta incompleto sin mostrar errores o exepciones de codigo
         */

        Scanner leer = new Scanner(System.in);
        int opc;
        final Repo_Cliente repo = new BaseDatos();
        final Servicio_Cliente_Interface servicio = new ServicioCliente(repo);

        do {
            System.out.println("-------MENU-------");
            System.out.println("1- Mostrar Clientes");
            System.out.println("2- Hacer Envio");
            System.out.println("3- Nuevo Cliente");
            System.out.println("0 -> SALIR");
            System.out.println("------------------");
            System.out.print("elige : ");
            opc = leer.nextInt();

            switch (opc){
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    servicio.mostrar();
                    break;
                case 2:
                    String id = JOptionPane.showInputDialog("Ingresa ID del CLiente");
                    Optional<Cliente> nuevoEnvio = Optional.ofNullable(servicio.newShipping(id));
                    nuevoEnvio.ifPresent(cliente -> System.out.println("\nHaciendo Envio para Cliente:\n" + cliente));
                    break;
                case 3:
                    String nombre = JOptionPane.showInputDialog("Ingresa el Nombre");
                    String apellido = JOptionPane.showInputDialog("Ingresa el Apellido");
                    int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el Num. de Telefono"));
                    String direccion = JOptionPane.showInputDialog("Ingresa la Direccion");
                    servicio.save(nombre,apellido,telefono,direccion);
                default:
                    System.out.println("Opc no Valida!!");
                    break;
            }

        } while(opc!=0);



    }



}