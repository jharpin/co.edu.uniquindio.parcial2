package co.edu.uniquindio.parcial2.mapping.mappers;

import co.edu.uniquindio.parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.mapping.dto.PrestamoDto;
import co.edu.uniquindio.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.model.Prestamo;
import co.edu.uniquindio.parcial2.service.IPrestamoMapping;

import java.util.ArrayList;
import java.util.List;

public  class PrestamoMappingImpl implements IPrestamoMapping {


    @Override
    public List<ClienteDto> getClientesDto(List<Cliente> listaClientes) {
        if (listaClientes == null) {
            return null;
        }
        List<ClienteDto> listaClientesDto = new ArrayList<ClienteDto>(listaClientes.size());
        for (Cliente cliente : listaClientes) {
            listaClientesDto.add(clienteToClienteDto(cliente));
        }

        return listaClientesDto;
    }

    @Override
    public ClienteDto clienteToClienteDto(Cliente cliente) {
        return new ClienteDto(
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getCedula(),
                cliente.getEmail(),
                cliente.getDireccion());
    }

    @Override
    public Cliente clienteDtoToCliente(ClienteDto clienteDto) {
        return Cliente.builder()
                .nombre(clienteDto.nombre())
                .apellido(clienteDto.apellido())
                .cedula(clienteDto.cedula())
                .email(clienteDto.email())
                .direccion(clienteDto.direccion())
                .build();
    }

    @Override
    public List<ObjetoDto> getObjetoDto(List<Objeto> listaObjetos) {
        if (listaObjetos == null) {
            return null;
        }
        List<ObjetoDto> listaObjetosDto = new ArrayList<ObjetoDto>(listaObjetos.size());
        for (Objeto objeto : listaObjetos) {
            listaObjetosDto.add(objetoToObjetoDto(objeto));
        }

        return listaObjetosDto;
    }
    @Override
    public List<PrestamoDto> getPrestamoDto(List<Prestamo> listaPrestamo) {
        if(listaPrestamo == null) {
            return null;
        }
            List<PrestamoDto>listaPrestamosDto=new ArrayList<>(listaPrestamo.size());
        for (Prestamo prestamo : listaPrestamo) {
            listaPrestamosDto.add(prestamoToPrestamoDto(prestamo));
        }
        return listaPrestamosDto;
    }

    @Override
    public ObjetoDto objetoToObjetoDto(Objeto objeto) {
        return new ObjetoDto(
                objeto.getNombreObjeto(),
                objeto.getIdObjeto());
    }

    @Override
    public Objeto objetoDtoToObjeto(ObjetoDto objetoDto) {
        return Objeto.builder()
                .nombreObjeto(objetoDto.nombreObjeto())
                .idObjeto(objetoDto.idObjeto())
                .build();
    }



    @Override
    public PrestamoDto prestamoToPrestamoDto(Prestamo prestamo) {
        return new PrestamoDto(
                prestamo.getNumeroPrestamo(),
                prestamo.getFechaPrestamo(),
                prestamo.getFechaEntrega(),
                prestamo.getDescripcion(),
                prestamo.getEmpleadoAsociado(),
                prestamo.getClienteAsociado(),
                prestamo.getListaObjetosAsociados(),
                prestamo.getOwnedByPrestamoUq());
    }

    @Override
    public Prestamo prestamoDtoToPrestamo(PrestamoDto prestamoDto) {
        return Prestamo.builder()
                .numeroPrestamo(prestamoDto.numeroPrestamo())
                .fechaPrestamo(prestamoDto.fechaPrestamo())
                .fechaEntrega(prestamoDto.fechaEntrega())
                .descripcion(prestamoDto.descripcion())
                .empleadoAsociado(prestamoDto.empleadoAsociado())
                .clienteAsociado(prestamoDto.clienteAsociado())
                .listaObjetosAsociados(prestamoDto.listaObjetosAsociados())
                .ownedByPrestamoUq(prestamoDto.ownedByPrestamoUq())
                .build();
    }


}
