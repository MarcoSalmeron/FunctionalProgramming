package org.example.Repositorios;

import org.example.Modelos.Persona;

import java.util.List;

//Repositorio con Acceso a Datos//
public interface Repo_Persona {

    //Mostrar
    List<Persona> all();

    //Guardar
    void save(String nombre, String apellido, int edad);
}
