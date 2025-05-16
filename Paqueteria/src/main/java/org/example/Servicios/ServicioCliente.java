package org.example.Servicios;

import org.example.Modelos.Cliente;
import org.example.Repositorios.Repo_Cliente;

import javax.swing.*;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

//Logica del Negocio//
public class ServicioCliente implements Servicio_Cliente_Interface{

    private final Repo_Cliente baseDatos;

    private List<Cliente> listaClientes;

    private BiPredicate<Cliente,String> buscarID = (c, id)->c.getNroCliente().equalsIgnoreCase(id);

    public ServicioCliente (Repo_Cliente baseDatos){
        this.baseDatos=baseDatos;
        this.listaClientes=baseDatos.all();
    }

    @Override
    public void mostrar() {
        listaClientes.forEach(System.out::println);
    }

    @Override
    public void save(String nombre, String apellido, int telefono, String direccion) {
        baseDatos.save(nombre,apellido,telefono,direccion);
    }

    @Override
    public Cliente newShipping(String id) {
        Optional<Cliente> buscarCliente = findById(listaClientes,id);
        if(buscarCliente.isPresent()){

            if(findAddress(buscarCliente).isPresent()){
                return buscarCliente.get();
            } else {
                System.out.println("ERROR FALTA DIRECCION!!!");
                JOptionPane.showMessageDialog(null,"NO TIENES UBICACION INGRESADA", "ERROR FALTAN CAMPOS",JOptionPane.ERROR_MESSAGE);
                buscarCliente.get().setDireccion(JOptionPane.showInputDialog("Ingresa Direccon Valida"));
            }
        } else {
            System.out.println("No existe este ID -> ["+id+"]");
        }
        return null;
    }

    /**
     * Buscar por Direccion y si no existe indicarlo
     */
    private Optional<Cliente> findById(List<Cliente> lista, String id) {
        return lista.stream()
                .filter(c->buscarID.test(c,id))
                .findFirst();
    }

    private Optional<String> findAddress(Optional<Cliente> cliente) {
        return cliente.map(Cliente::getDireccion);
    }


}
