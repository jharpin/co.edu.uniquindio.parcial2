package co.edu.uniquindio.parcial2.EjemploFactoryMethod.Model;


public class EmpleadoPermanente extends Empleado {

        public EmpleadoPermanente(String cedula, String nombre, String apellido, int edad) {
            super(cedula, nombre, apellido, edad);
        }

        @Override
        public String getTipo() {
            return "Permanente";
        }
    }

