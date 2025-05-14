package org.example.Servicios;

import org.example.Modelos.Persona;
import org.example.Repositorios.BaseDatos;
import org.example.Repositorios.Repo_Persona;

import javax.swing.*;
import java.util.List;
import java.util.function.Predicate;

//Servicio con la Logica//
public class Serv_Persona implements Serv_Persona_Interface{

    //Dependencia del Repositorio
    private final Repo_Persona baseDatos = new BaseDatos();

    //Usar Registros en Base de Datos
    private List<Persona> listaPersonas = baseDatos.all();

    //Verificar atributo de Persona
    private Predicate<Persona> esMayorDe25 = persona -> persona.getEdad()>=25;

    @Override
    public List<Persona> filtrarEdades(List<Persona> registros, Predicate<Persona> filtro){
        return registros.stream()
                .filter(filtro)
                .toList();
    }

    @Override
    public void getPersonas(){
        for(Persona pers: listaPersonas){
            System.out.println(pers);
            System.out.println("\n");
        }

    }

    @Override
    public void getPersonasMayores(){
        //Filtrar
        List<Persona> mayores25 = filtrarEdades(listaPersonas, esMayorDe25);
        for(Persona pers : mayores25){
            System.out.println(pers);
            System.out.println("\n");
        }

    }

    @Override
    public void savePersona(){
        String nombre = JOptionPane.showInputDialog("Ingresa el Nombre");
        String apellido = JOptionPane.showInputDialog("Ingresa el Apellido");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la Edad"));
        baseDatos.save(nombre,apellido,edad);
    }
}
