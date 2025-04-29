package co.edu.uniquindio.parcial2.EjemploFactoryMethod.Model;

public class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(String cedula, String nombre, String apellido, int edad) {
        super(cedula, nombre, apellido, edad);
    }

    @Override
    public String getTipo() {
        return "Temporal";
    }
}
