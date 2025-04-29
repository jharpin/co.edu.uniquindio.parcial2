package co.edu.uniquindio.parcial2.mapping.dto;

import co.edu.uniquindio.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.EjemploFactoryMethod.Model.Empleado;
import co.edu.uniquindio.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.model.PrestamoObjeto;


import java.time.LocalDate;
import java.util.List;

public record PrestamoDto(
        String numeroPrestamo,
        LocalDate fechaPrestamo,
        LocalDate fechaEntrega,
        String descripcion,
        EmpleadoDto empleadoAsociado,
        List<ObjetoDto> listaObjetosAsociados,
        ClienteDto ownedByPrestamoUq
) {

    public String getNombreCliente() {
        return ownedByPrestamoUq != null ? ownedByPrestamoUq.nombre() : "Sin cliente";
    }

    public String getNombreObjeto() {
        return listaObjetosAsociados != null && !listaObjetosAsociados.isEmpty()
                ? listaObjetosAsociados.get(0).nombreObjeto()
                : "Sin objeto";
    }
}

