package org.example.Servicios;

import org.example.Modelos.Cliente;

//Interfaz de Manipulacion a Datos//
public interface Servicio_Cliente_Interface {

    //mostrar//
    void mostrar();

    //guardar//
    void save(String nombre, String apellido, int telefono, String direccion);

    //hacer envio//
    Cliente newShipping (String id);
}
