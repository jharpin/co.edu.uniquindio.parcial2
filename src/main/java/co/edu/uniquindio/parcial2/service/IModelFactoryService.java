package co.edu.uniquindio.parcial2.service;

import co.edu.uniquindio.parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.mapping.dto.ObjetoDto;

import java.util.List;

public interface IModelFactoryService {
    List<ClienteDto> obtenerClientes();
    List<ObjetoDto> obtenerObjetos();
    boolean agregarCliente(ClienteDto clienteDto);
    boolean actualizarCliente(ClienteDto clinetedto);
    boolean eliminarCliente(String cedula);
    boolean agregarObjeto(ObjetoDto objetoDto);
    boolean eliminarObjeto(String idObjeto);
}
