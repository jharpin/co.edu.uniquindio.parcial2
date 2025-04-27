package co.edu.uniquindio.parcial2.mapping.dto;

import co.edu.uniquindio.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.model.Empleado;
import co.edu.uniquindio.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.model.PrestamoObjeto;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record PrestamoDto(
        String numeroPrestamo,
        LocalDate fechaPrestamo,
        LocalDate fechaEntrega,
        String descripcion,
        Empleado empleadoAsociado,
        Cliente clienteAsociado,
        List<Objeto> listaObjetosAsociados,
        PrestamoObjeto ownedByPrestamoUq
) {
}
