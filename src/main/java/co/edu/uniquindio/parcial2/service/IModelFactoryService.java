package co.edu.uniquindio.parcial2.service;

import co.edu.uniquindio.parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.mapping.dto.PrestamoDto;

import java.util.List;

public interface IModelFactoryService {
    List<ClienteDto> obtenerClientes();
    List<ObjetoDto> obtenerObjetos();
    List<PrestamoDto>obtenerPrestamos();
    boolean agregarCliente(ClienteDto clienteDto);
    boolean actualizarCliente(ClienteDto clinetedto);
    boolean eliminarCliente(String cedula);
    boolean agregarObjeto(ObjetoDto objetoDto);
    boolean eliminarObjeto(String idObjeto);
    boolean actualizarObjeto(ObjetoDto objetoDto);
    boolean agregarPrestamo(PrestamoDto prestamoDto);
    boolean actualizarPrestamo(PrestamoDto prestamoDto);
    boolean eliminarPrestamo(String numeroPrestamo);
}
