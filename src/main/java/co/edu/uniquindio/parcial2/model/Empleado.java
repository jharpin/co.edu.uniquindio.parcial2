package co.edu.uniquindio.parcial2.model;

import co.edu.uniquindio.parcial2.model.builder.EmpleadoBuilder;



public class Empleado extends  Persona {
    PrestamoObjeto ownedByPrestamoUq;
    private String correo;
    private String direccion;

    public Empleado(String cedula, String nombre, String apellido, int edad, String correo, String direccion) {
        super(cedula, nombre, apellido, edad);
        this.correo = correo;
        this.direccion = direccion;
    }

    public Empleado() {
    }

    public static Empleado builder() {
        return new Empleado();
    }

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }
}
