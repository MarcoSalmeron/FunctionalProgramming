package org.example.Modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;

//Modelo a Abstraer//
@Getter
@AllArgsConstructor
public class Persona {

    //Atributos Inmutables//
    private final String nombre;
    private final String apellido;
    private final int edad;

    @Override
    public String toString() {
        return "Persona {\n" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                "\n}";
    }


}
