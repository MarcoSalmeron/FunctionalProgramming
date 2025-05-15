package org.Tirando.Codigo.Servicios;

import org.Tirando.Codigo.Modelos.Auto;

import java.util.List;

//Metodos a Definir en Servicio//
public interface ServicioAuto_Interface {

    //Ordenar por Precio//
    void sortByPrice();

    //Ordenar por Marca y Precio//
    void sortByBrandAndPrice();

    //Buscar Precios Menores a 23k//
    List<Auto> findLowerPrices();

    //Buscar por Marca//
    List<Auto> findByBrand(String brand);

    //Buscar modelo que contenga letra especifica//
    List<Auto> findByLetter(char letter);

    //guardar//
    void saveAuto(String marca,String modelo,double precio, String matricula);

    //buscar por ID//
    Auto findById(String id);

    //mostrar//
    void all();


}
