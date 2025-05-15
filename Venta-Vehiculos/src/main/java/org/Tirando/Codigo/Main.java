package org.Tirando.Codigo;

import org.Tirando.Codigo.Repositorios.BaseDatos;
import org.Tirando.Codigo.Repositorios.Repo_Interface;
import org.Tirando.Codigo.Servicios.ServicioAuto;
import org.Tirando.Codigo.Servicios.ServicioAuto_Interface;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /**
         *
         * Aplicacion para Gestionar Venta de Vehiculos
         * Auto -> Marca - Modelo - Precio - Matricula
         *
         * 1- Ordenar por precio de Menor a Mayor
         * 2- Ordenar por Marca y Precio
         * 3- Filtrar solo precios menores a 23k
         * 4- Filtrar solo por Marcas a buscar
         * 5- Mostrar modelos que contenga letra a buscar
         * 6- Guardar Auto en B.D
         * 7- Buscar por ID
         *
         *  (Finalizar Programa hasta que el Usuario Quiera)
         */
        Scanner leer = new Scanner(System.in);
        int opc;

        //Dependencia del Servicio con Logica del Negocio//
        final Repo_Interface repo = new BaseDatos();
        final ServicioAuto_Interface servicio = new ServicioAuto(repo);


        do {
            System.out.println("\n-----------SISTEMA----------");
            System.out.println("----Gestion de Vehiculos----");
            System.out.println("----------------------------");
            System.out.println("1- Ordenar por precio de Menor a Mayor");
            System.out.println("2- Ordenar por Marca y Precio");
            System.out.println("3- Filtrar solo precios menores a 23k");
            System.out.println("4- Filtrar solo por Marcas a buscar");
            System.out.println("5- Mostrar modelos que contenga letra a buscar");
            System.out.println("6- Guardar Auto");
            System.out.println("7- Buscar por ID");
            System.out.println("8- Mostrar Todos");
            System.out.println("0 -> SALIR");
            System.out.println("----------------------------");
            System.out.print("elige: ");
            opc = leer.nextInt();

            switch (opc){
                case  0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    servicio.sortByPrice();
                    break;
                case 2:
                    servicio.sortByBrandAndPrice();
                    break;
                case 3:
                    System.out.println(servicio.findLowerPrices());
                    break;
                case 4:
                    String nMarca = JOptionPane.showInputDialog("Marca a Buscar");
                    System.out.println(servicio.findByBrand(nMarca));
                    break;
                case 5:
                    String letra = JOptionPane.showInputDialog("Letra a Buscar");
                    System.out.println(servicio.findByLetter(letra.charAt(0)));
                    break;
                case 6:
                    String marca = JOptionPane.showInputDialog("Marca del Carro");
                    String modelo = JOptionPane.showInputDialog("Modelo del Carro");
                    double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del Carro"));
                    String matricula = JOptionPane.showInputDialog("Matricula del Carro");
                    servicio.saveAuto(marca,modelo,precio, matricula);
                    break;
                case 7:
                    try{
                        String id = JOptionPane.showInputDialog("ID a Buscar");
                        System.out.println(servicio.findById(id));
                    } catch (NullPointerException ex){
                        System.out.println("ERROR ->"+ex.getMessage());
                    } finally {
                        break;
                    }
                case 8:
                    servicio.all();
                    break;
                default:
                    System.out.println("Opcion no Valida!!!");
                    break;
            }
        } while (opc != 0);

    }
}