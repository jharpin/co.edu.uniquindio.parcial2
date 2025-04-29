package co.edu.uniquindio.parcial2.model.builder;

import co.edu.uniquindio.parcial2.model.Empleado;

public class EmpleadoBuilder {
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String correo;
    protected String direccioon;

    public EmpleadoBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public EmpleadoBuilder nombre(String nombre) {
        this.nombre = nombre;
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
    public EmpleadoBuilder direccioon(String direccioon) {
        this.direccioon = direccioon;
        return this;
    }
    public Empleado build() {
        return new Empleado(cedula, nombre, apellido, edad,correo,direccioon);
    }

}


