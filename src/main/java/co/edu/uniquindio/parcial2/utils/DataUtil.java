package co.edu.uniquindio.parcial2.utils;

import co.edu.uniquindio.parcial2.controller.EmpleadoController;
import co.edu.uniquindio.parcial2.model.*;
import co.edu.uniquindio.parcial2.model.PrestamoObjeto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class DataUtil {

    public static PrestamoObjeto inicializarDatos() {
        PrestamoObjeto prestamoObjeto = new PrestamoObjeto();
        Cliente cliente1 = Cliente.builder()
                .cedula("1094")
                .nombre("juan")
                .apellido("arias")
                .direccion("armenia")
                .edad(17)
                .email("jsjsj@gmail.com")
                .build();

        Cliente cliente2 = Cliente.builder()
                .cedula("1095")
                .nombre("Ana")
                .apellido("cardenas")
                .direccion("quimbaya")
                .edad(25)
                .email("jsjsj2@gmail.com")
                .build();

        Cliente cliente3 = Cliente.builder()
                .cedula("1096")
                .nombre("Pedro")
                .apellido("perez")
                .direccion("armenia")
                .edad(40)
                .email("jsjsj3@gmail.com")
                .build();

        Objeto objeto = Objeto.builder()
                .nombreObjeto("carro")
                .idObjeto("678")
                .build();

        Objeto objeto1 = Objeto.builder()
                .nombreObjeto("motos")
                .idObjeto("777")
                .build();
        Objeto objeto2 = Objeto.builder()
                .idObjeto("888")
                .nombreObjeto("casas")
                .build();


        Prestamo prestamo1=Prestamo.builder()
                .numeroPrestamo("1234")
                .fechaPrestamo(LocalDate.of(2020, 1, 1))
                .fechaEntrega(LocalDate.of(2020, 1, 3))
                .clienteAsociado(cliente1)
                .listaObjetosAsociados(List.of(objeto1))
                .empleadoAsociado(null)
                .ownedByPrestamoUq(null)
                        .build();

        Empleado empleado1 =Empleado.builder()
                .nombre("ana")
                .apellido("diaz")
                .cedula("1097")
                .direccion("armenia")
                .correo("ana@gmail.com")
                .edad(6)
                        .build();
        Empleado empleado2= Empleado.builder()
                .nombre("pedro")
                .apellido("perez")
                .cedula("1098")
                .direccion("pereira")
                .correo("pedro@gmail.com")
                .edad(7)
                        .build();
        Empleado empleado2 =Empleado.builder()
                .nombre("laura")
                .apellido("diaz")
                .cedula("2089")
                .direccion("armenia")
                .correo("laura@gmail.com")
                .tipoEmpleado("Permanente")
                .build();

        prestamoObjeto.getListaObjetos().add(objeto);
        prestamoObjeto.getListaObjetos().add(objeto1);
        prestamoObjeto.getListaObjetos().add(objeto2);
        prestamoObjeto.getListaClientes().add(cliente1);
        prestamoObjeto.getListaClientes().add(cliente2);
        prestamoObjeto.getListaClientes().add(cliente3);
        prestamoObjeto.getListaPrestamos().add(prestamo1);
        prestamoObjeto.getListaEmpleados().add(empleado1);
        prestamoObjeto.getListaEmpleados().add(empleado2);
        return prestamoObjeto;
    }
}
