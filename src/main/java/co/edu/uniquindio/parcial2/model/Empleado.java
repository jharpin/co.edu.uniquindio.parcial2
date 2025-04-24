package co.edu.uniquindio.parcial2.model;

import co.edu.uniquindio.parcial2.model.builder.ClienteBuilder;
import co.edu.uniquindio.parcial2.model.builder.EmpleadoBuilder;

public class Empleado extends  Persona{
    PrestamoObjeto ownedByPrestamoUq;

    public Empleado(String cedula, String nombre, String apellido, int edad) {
        super(cedula, nombre, apellido, edad);
    }
    public Empleado() {
    }
    public static EmpleadoBuilder builder() {return new EmpleadoBuilder();}
    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }

}
