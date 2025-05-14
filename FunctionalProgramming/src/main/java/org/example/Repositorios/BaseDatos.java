package org.example.Repositorios;

import org.example.Modelos.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Definir el Acceso a Datos//
public class BaseDatos implements Repo_Persona {

    private List<Persona> datos = new ArrayList<>( Arrays.asList(
            new Persona("Marco","Ramirez",21),
            new Persona("Antonio","Salmeron",19),
            new Persona("Omar","Gomez",25),
            new Persona("Gerardo","Perez",26)
    ));

    @Override
    public List<Persona> all() {
        return this.datos;
    }

    @Override
    public void save(String nombre, String apellido, int edad) {
        this.datos.add(new Persona(nombre,apellido,edad));
        System.out.println("Persona Guardada con Exito!");
    }


}
