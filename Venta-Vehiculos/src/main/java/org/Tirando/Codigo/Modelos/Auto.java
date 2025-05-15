package org.Tirando.Codigo.Modelos;

import lombok.Getter;
import lombok.Setter;

@Getter     @Setter
public class Auto extends Vehiculo{

    private static int id = 0;
    private final String id_Auto;
    private String matricula;

    public Auto(String marca, String modelo, double precio, String matricula) {
        super(marca, modelo, precio);
        this.matricula=matricula;
        this.id_Auto="AUTO-"+(++id);
    }


    @Override
    public String toString() {
        return "\nAuto{\n" +
                "ID_Auto = "+id_Auto+
                "\nMatricula = "+matricula+
                "\nMarca = "+ getMarca()+
                "\nModelo = "+ getModelo()+
                "\nPrecio = "+ getPrecio()+
                "\n}\n";
    }
}
