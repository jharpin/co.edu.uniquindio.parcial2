package co.edu.uniquindio.parcial2.controller;
import co.edu.uniquindio.parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.mapping.dto.EmpleadoDto;
import java.util.List;
public class EmpleadoController {
    ModelFactory modelFactory;
    public EmpleadoController(){modelFactory=ModelFactory.getInstancia();}

    public List<EmpleadoDto> obtenerEmpleados(){
        return modelFactory.obtenerEmpleados();
    }

    public boolean agregarEmpleado(EmpleadoDto empleadoDto){
        return modelFactory.agregarEmpleado(empleadoDto);
    }
    public boolean actualizarEmpleado(EmpleadoDto empleadoDto){
        return modelFactory.actualizarEmpleado(empleadoDto);}
    public boolean eliminarEmpleado(String cedula){return modelFactory.eliminarEmpleado(cedula);}
}
