package co.edu.uniquindio.parcial2.model.builder;

import co.edu.uniquindio.parcial2.model.Empleado;

public class EmpleadoBuilder {

    protected String nombre;
    protected String cedula;
    protected String apellido;
    protected int edad;
    protected String correo;
    protected String direccioon;
    protected String tipoEmpleado;


    public EmpleadoBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public EmpleadoBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }
    public EmpleadoBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public EmpleadoBuilder edad(int edad) {
        this.edad = edad;
        return this;
    }
    public EmpleadoBuilder correo(String correo) {
        this.correo= correo;
        return this;
    }
    public EmpleadoBuilder direccion(String direccioon) {
        this.direccioon = direccioon;
        return this;
    }
    public EmpleadoBuilder tipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
        return this;
    }
    public Empleado build() {
        return new Empleado( nombre,cedula, apellido, edad,correo,direccioon, tipoEmpleado);
    }

}


