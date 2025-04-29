package co.edu.uniquindio.parcial2.controller;
import co.edu.uniquindio.parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.mapping.dto.ObjetoDto;
import co.edu.uniquindio.parcial2.mapping.dto.PrestamoDto;
import java.util.List;
public class PrestamoController {
    ModelFactory modelFactory;
    public PrestamoController(){modelFactory=ModelFactory.getInstancia();}

    public List<PrestamoDto> obtenerPrestamos() {return modelFactory.obtenerPrestamos();}
    public boolean agregarPrestamo(PrestamoDto prestamoDto) {return modelFactory.agregarPrestamo(prestamoDto);}
    public boolean actualizarPrestamo(PrestamoDto prestamoDto) {return modelFactory.actualizarPrestamo(prestamoDto);}
    public boolean eliminarPrestamo(String numeroPrestamo) {return modelFactory.eliminarPrestamo(numeroPrestamo);}


}
