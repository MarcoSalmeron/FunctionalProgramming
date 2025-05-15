package org.Tirando.Codigo.Repositorios;

import org.Tirando.Codigo.Modelos.Auto;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;


//Repo de Acceso a Datos//
public interface Repo_Interface {

    //mostrar//
    List<Auto> all();

    //guardar//
    void save(String marca, String modelo, double precio, String matricula);

    //filtrar//
    List<Auto> filter(List<Auto> lista, Predicate<Auto> filtro);

    //filtrar por argumento //
    List<Auto> filter(List<Auto> lista, BiPredicate<Auto,String> filtro, String dato);

    //Buscar//
    Auto find(List<Auto> lista, BiPredicate<Auto,String> filtro, String dato);
}
