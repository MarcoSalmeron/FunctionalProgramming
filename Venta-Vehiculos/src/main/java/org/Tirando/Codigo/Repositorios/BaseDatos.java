package org.Tirando.Codigo.Repositorios;

import org.Tirando.Codigo.Modelos.Auto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

//Definir el acceso a datos//
public class BaseDatos implements Repo_Interface{

    /**
     * Registros a usar con precios ya pre-definidos
     */
    private List<Auto> registros = new ArrayList<>(Arrays.asList(
            new Auto("Volkswagen", "Amorok", 25000.200,"ABC-123"),
            new Auto("Volkswagen", "Taos", 32000.500,"DEF-456"),
            new Auto("Chevrolet", "Onix", 22000.400, "GHI-789"),
            new Auto("Chevrolet", "Tracker", 30000.200,"JKL-1011"),
            new Auto("Fiat", "Cronos", 21000.400,"MNO-1213"),
            new Auto("Fiat", "Pulse", 24000.100, "PQR-1415"),
            new Auto("Toyota", "Corolla", 28000.200,"STW-1617"),
            new Auto("Toyota", "Yaris", 23000.100,"XYZ-1819"),
            new Auto("Renault", "Stepway", 20000.600,"HIE189"),
            new Auto("Renault", "Duster", 27000.100,"OPJ870"),
            new Auto("Nissan", "Versa", 25000.200,"RTEW34")
    ));

    @Override
    public List<Auto> all() {
        return this.registros;
    }

    @Override
    public void save(String marca, String modelo, double precio, String matricula) {
        this.registros.add(new Auto(marca,modelo,precio,matricula));
        System.out.println("Guardado Exitosamente!");
    }

    @Override
    public List<Auto> filter(List<Auto> lista, Predicate<Auto> filtro) {
        return lista.stream()
                .filter(filtro)
                .toList();
    }

    @Override
    public List<Auto> filter(List<Auto> lista, BiPredicate<Auto, String> filtro, String dato) {
        return lista.stream()
                .filter(auto->filtro.test(auto,dato))
                .toList();
    }

    @Override
    public Auto find(List<Auto> lista, BiPredicate<Auto, String> filtro, String dato) {
        return lista.stream()
                .filter(auto->filtro.test(auto,dato))
                .findFirst()
                .orElseThrow(()->new NullPointerException("Objeto Inexistente!!"));
    }

}
