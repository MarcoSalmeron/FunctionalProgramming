package org.Tirando.Codigo.Servicios;

import org.Tirando.Codigo.Modelos.Auto;
import org.Tirando.Codigo.Modelos.Vehiculo;
import org.Tirando.Codigo.Repositorios.Repo_Interface;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

//Servicio con la Logica del Negocio//
public class ServicioAuto implements ServicioAuto_Interface{

    //Dependencia de Base de Datos//
    private final Repo_Interface baseDatos;

    //usar registros en la base de datos//
    private List<Auto> listAutos;

    //Inyeccion de Dependencias//
    public ServicioAuto (Repo_Interface baseDatos){
        this.baseDatos=baseDatos;
        this.listAutos=baseDatos.all();
    }

    /**
     * Filtros a Definir
     */
    private Predicate<Auto> preciosMenores = a->Math.floor(a.getPrecio())<=23000;

    private BiPredicate<Auto,String> filtrarMarca = (auto, marca) -> auto.getMarca().toLowerCase().equals(marca.toLowerCase());

    private BiPredicate<Auto, String> contieneLetra = (auto, dato ) -> auto.getModelo().toLowerCase().contains(dato.toLowerCase());

    private BiPredicate<Auto,String> buscarID = (auto,id) -> auto.getId_Auto().equals(id.toUpperCase());

    @Override
    public void sortByPrice() {
        listAutos.stream()
                .sorted(Comparator.comparing(Vehiculo::getPrecio))
                .forEach(System.out::println);
    }

    @Override
    public void sortByBrandAndPrice() {
        listAutos.stream()
                .sorted(Comparator
                        .comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getPrecio))
                .forEach(System.out::println);
    }

    @Override
    public List<Auto> findLowerPrices() {
        List<Auto> lowerPrices = baseDatos.filter(listAutos,preciosMenores);
        return lowerPrices;
    }

    @Override
    public List<Auto> findByBrand(String brand) {
       List<Auto> findBrand = baseDatos.filter(listAutos,filtrarMarca,brand);
       return findBrand;
    }

    @Override
    public List<Auto> findByLetter(char letter) {
        List<Auto> findLetter = baseDatos.filter(listAutos,contieneLetra,Character.toString(letter));
        return findLetter;
    }

    @Override
    public void saveAuto(String marca,String modelo,double precio, String matricula) {
        baseDatos.save(marca,modelo,precio,matricula);
    }

    @Override
    public Auto findById(String id) throws NullPointerException{
        Auto findID = baseDatos.find(listAutos,buscarID,id);
        return findID;
    }

    @Override
    public void all() {
        listAutos.forEach(System.out::println);
    }




}
