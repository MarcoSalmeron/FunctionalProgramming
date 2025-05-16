package org.example.Modelos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Modelo a Abstraer//
@Getter @Setter
@ToString
public class Cliente extends Persona{

    /**
     *
     * clientes -> nro_cliente, nombre, apellido, direccion, telefono
     */
    private static int id = 0;
    private final String nroCliente;
    private String direccion;


    /**
     * Constructor Completo
     * @param nombre
     * @param apellido
     * @param telefono
     */
    public Cliente(String nombre, String apellido, int telefono, String direccion) {
        super(nombre, apellido, telefono);
        this.direccion=direccion;
        this.nroCliente="CLTE-"+(++id);
    }
}
