package co.edu.uniquindio.parcial2.model;

import co.edu.uniquindio.parcial2.model.builder.ClienteBuilder;
import co.edu.uniquindio.parcial2.model.builder.EmpleadoBuilder;

public abstract class Empleado extends  Persona{
    private PrestamoObjeto ownedByPrestamoUq;
    private String email;
    private String direccion;

    public Empleado(String cedula, String nombre, String apellido, int edad) {
        super(cedula, nombre, apellido, edad);
    }

    public abstract String getTipo();

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }

    // 🔵 Agregado: Getters y Setters de email y direccion
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}





