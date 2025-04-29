package co.edu.uniquindio.parcial2.model;

import co.edu.uniquindio.parcial2.EjemploFactoryMethod.Model.Empleado;
import co.edu.uniquindio.parcial2.model.builder.PrestamoBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private String numeroPrestamo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private String descripcion;
    private Empleado empleadoAsociado;
    private Cliente clienteAsociado;
    List<Objeto> listaObjetosAsociados = new ArrayList<>();
    PrestamoObjeto ownedByPrestamoUq;

public Prestamo(String numeroPrestamo, LocalDate fechaPrestamo, LocalDate fechaEntrega, String descripcion,Empleado empleadoAsociado, Cliente clienteAsociado,List<Objeto> listaObjetosAsociados, PrestamoObjeto ownedByPrestamoUq) {
    this.numeroPrestamo = numeroPrestamo;
    this.fechaPrestamo = fechaPrestamo;
    this.fechaEntrega = fechaEntrega;
    this.descripcion = descripcion;
    this.empleadoAsociado = empleadoAsociado;
    this.clienteAsociado = clienteAsociado;
    this.listaObjetosAsociados = listaObjetosAsociados;
    this.ownedByPrestamoUq = ownedByPrestamoUq;

}
    public Prestamo() {
    }

    public String getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(String numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empleado getEmpleadoAsociado() {
        return empleadoAsociado;
    }

    public void setEmpleadoAsociado(Empleado empleadoAsociado) {
        this.empleadoAsociado = empleadoAsociado;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public List<Objeto> getListaObjetosAsociados() {
        return listaObjetosAsociados;
    }

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;}

    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;}

    public void setListaObjetosAsociados(List<Objeto> listaObjetosAsociados) {
        this.listaObjetosAsociados = listaObjetosAsociados;
    }
    public static PrestamoBuilder builder() {
    return new PrestamoBuilder();
    }
}
