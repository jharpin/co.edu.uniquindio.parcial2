package co.edu.uniquindio.parcial2.EjemploFactoryMethod.factory;

import co.edu.uniquindio.parcial2.EjemploFactoryMethod.Model.Empleado;
import co.edu.uniquindio.parcial2.EjemploFactoryMethod.Model.EmpleadoPermanente;
import co.edu.uniquindio.parcial2.EjemploFactoryMethod.Model.EmpleadoTemporal;

public class EmpleadoFactory {
    public static Empleado crearEmpleado(String tipo, String cedula, String nombre, String apellido, int edad) {
        switch (tipo.toLowerCase()) {
            case "permanente":
                return new EmpleadoPermanente(cedula, nombre, apellido, edad);
            case "temporal":
                return new EmpleadoTemporal(cedula, nombre, apellido, edad);
            default:
                throw new IllegalArgumentException("Tipo de empleado no válido: " + tipo);
        }
    }
}


