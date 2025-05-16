package org.example.Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Persona {

    private final String nombre, apellido;
    private int telefono;
}
