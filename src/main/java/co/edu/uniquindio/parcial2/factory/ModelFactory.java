package co.edu.uniquindio.parcial2.factory;

import co.edu.uniquindio.parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.mapping.dto.PrestamoDto;
import co.edu.uniquindio.parcial2.mapping.mappers.PrestamoMappingImpl;
import co.edu.uniquindio.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.model.Prestamo;
import co.edu.uniquindio.parcial2.model.PrestamoObjeto;
import co.edu.uniquindio.parcial2.service.IModelFactoryService;
import co.edu.uniquindio.parcial2.service.IPrestamoMapping;
import co.edu.uniquindio.parcial2.utils.DataUtil;

import java.util.List;

public class ModelFactory implements IModelFactoryService {
    private static ModelFactory modelFactory;
    private PrestamoObjeto prestamoObjeto;
    private IPrestamoMapping mapper;

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory(){
        mapper = new PrestamoMappingImpl();
        prestamoObjeto = DataUtil.inicializarDatos();
    }


    @Override
    public List<ClienteDto> obtenerClientes() {
        return mapper.getClientesDto(prestamoObjeto.getListaClientes());
    }

    @Override
    public List<ObjetoDto> obtenerObjetos() {
        return mapper.getObjetoDto(prestamoObjeto.getListaObjetos());
    }

    @Override
    public List<PrestamoDto> obtenerPrestamos() {
        return mapper.getPrestamoDto(prestamoObjeto.getListaPrestamos());
    }

    @Override
    public boolean agregarCliente(ClienteDto clienteDto) {
        Cliente cliente = mapper.clienteDtoToCliente(clienteDto);
        return prestamoObjeto.crearCliente(cliente);
        //return prestamoObjeto.crearCliente(mapper.clienteDtoToCliente(clienteDto));
    }

    @Override
    public boolean actualizarCliente(ClienteDto clinetedto) {
        Cliente cliente = mapper.clienteDtoToCliente(clinetedto);
        return prestamoObjeto.actualizarCliente(cliente);
    }

    @Override
    public boolean eliminarCliente(String cedula) {
        return prestamoObjeto.eliminarCliente(cedula);
    }


    @Override
    public boolean agregarEmpleado() {
        return false;
    }
    @Override
    public boolean actualizarEmpleado() {
         return false;
           }

    @Override
    public boolean eliminarEmpleado() {
        return false;
    }

    @Override
    public boolean agregarObjeto(ObjetoDto objetoDto) {
       Objeto objeto = mapper.objetoDtoToObjeto(objetoDto);
        return prestamoObjeto.crearObjeto(objeto);
    }

    @Override
    public boolean eliminarObjeto(String idObjeto) {
        return prestamoObjeto.eliminarObjeto(idObjeto);
    }

    @Override
    public boolean actualizarObjeto(ObjetoDto objetoDto) {
        Objeto objeto = mapper.objetoDtoToObjeto(objetoDto);

        return prestamoObjeto.actualizarObjeto(objeto);
    }

    @Override
    public boolean agregarPrestamo(PrestamoDto prestamoDto) {
        Prestamo prestamo = mapper.prestamoDtoToPrestamo(prestamoDto);
        return prestamoObjeto.crearPrestamo(prestamo);
    }
    @Override
    public boolean eliminarPrestamo(String numeroPrestamo) {return prestamoObjeto.eliminarPrestamo(numeroPrestamo);}
    @Override
    public boolean actualizarPrestamo(PrestamoDto prestamoDto) {
        Prestamo prestamo=mapper.prestamoDtoToPrestamo(prestamoDto);
        return prestamoObjeto.actualizarPrestamo(prestamo);
    }


}
