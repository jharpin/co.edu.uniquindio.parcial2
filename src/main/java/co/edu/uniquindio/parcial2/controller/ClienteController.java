package co.edu.uniquindio.parcial2.controller;

import co.edu.uniquindio.parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.mapping.dto.ClienteDto;

import java.util.List;

public class ClienteController {
    ModelFactory modelFactory;
    public ClienteController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<ClienteDto> obtenerClientes() {
        return modelFactory.obtenerClientes();
    }

    public boolean agregarCliente(ClienteDto clienteDto) {
        return modelFactory.agregarCliente(clienteDto);
    }

    public boolean actualizarCliente(ClienteDto clienteDto) {
        return  modelFactory.actualizarCliente(clienteDto);
    }

    public boolean eliminarCliente(String cedula) {return modelFactory.eliminarCliente(cedula);}
}
