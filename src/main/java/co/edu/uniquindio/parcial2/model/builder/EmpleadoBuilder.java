package co.edu.uniquindio.parcial2.model.builder;
import co.edu.uniquindio.parcial2.model.Empleado;
public class EmpleadoBuilder {
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected int edad;

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

}
