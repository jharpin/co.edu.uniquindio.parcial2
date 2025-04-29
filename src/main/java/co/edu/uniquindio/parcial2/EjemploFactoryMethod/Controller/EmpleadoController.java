package co.edu.uniquindio.parcial2.EjemploFactoryMethod.Controller;

import co.edu.uniquindio.parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.EjemploFactoryMethod.Model.Empleado;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoController {
    ModelFactory modelFactory;
    public EmpleadoController(){
        modelFactory = ModelFactory.getInstancia();
    }

    private List<Empleado> empleados = new ArrayList<>();
    public boolean agregarEmpleado() {
        return modelFactory.agregarEmpleado();
    }

    public boolean actualizarEmpleado() {
        return  modelFactory.actualizarEmpleado();
    }

    public boolean eliminarEmpleado(String cedula) {return modelFactory.eliminarEmpleado();}

}
