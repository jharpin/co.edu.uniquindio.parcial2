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

    public static EmpleadoBuilder builder(){
        return new EmpleadoBuilder();
    }

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }



 }
