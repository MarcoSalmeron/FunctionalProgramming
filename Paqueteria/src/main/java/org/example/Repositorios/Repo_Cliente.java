package org.example.Repositorios;

import org.example.Modelos.Cliente;

import java.util.List;
import java.util.function.BiPredicate;

//Interfaz de Acceso a Datos//
public interface Repo_Cliente {

    //Retornar Registros//
    List<Cliente> all();

    //guardar//
    void save(String nombre, String apellido, int telefono, String direccion);


}
