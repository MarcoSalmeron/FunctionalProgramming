package org.example.Servicios;


import org.example.Modelos.Persona;

import java.util.List;
import java.util.function.Predicate;

//Repositorio de Acceso a Datos
public interface Serv_Persona_Interface {

    //Filtrar por Edades//
    List<Persona> filtrarEdades(List<Persona> registros, Predicate<Persona> filtro);

    //Mostrar Registros//
    void getPersonas();

    //Mostrar Registros Filtrados//
    void getPersonasMayores();

    //Guardar Nuevo Registro//
    void savePersona();
}
