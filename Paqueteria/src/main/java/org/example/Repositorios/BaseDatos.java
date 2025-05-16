package org.example.Repositorios;

import org.example.Modelos.Cliente;

import java.util.Arrays;
import java.util.List;

//Definir Acceso a Datos//
public class BaseDatos implements Repo_Cliente {

    private List<Cliente> registros;


    @Override
    public List<Cliente> all() {
        return this.registros = Arrays.asList(
                new Cliente("Marco","Salmeron",123,null),
                new Cliente("Antonio","Ramirez",456,null),
                new Cliente("Sergio","Ramos",789,null),
                new Cliente("Adrian","Ramos",1011,null),
                new Cliente("Marc","Anthony",1314,"Jacarandas #8")
        );
    }

    @Override
    public void save(String nombre, String apellido, int telefono, String direccion) {
        if(registros.isEmpty()){
            registros=all();
        }
        this.registros.add(new Cliente(nombre,apellido,telefono,direccion));
        System.out.println("Registro Guardado!!!");
    }
}
