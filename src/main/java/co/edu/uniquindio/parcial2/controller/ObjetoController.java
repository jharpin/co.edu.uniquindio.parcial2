package co.edu.uniquindio.parcial2.controller;

import co.edu.uniquindio.parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.mapping.dto.ObjetoDto;

import java.util.List;

public class ObjetoController {
    ModelFactory modelFactory;
    public ObjetoController(){
        modelFactory = ModelFactory.getInstancia();
    }

    public List<ObjetoDto> obtenerObjetos() {
        return modelFactory.obtenerObjetos();
    }

    public boolean agregarObjeto(ObjetoDto objetoDto) {
        return modelFactory.agregarObjeto(objetoDto);
    }

    public boolean actualizarObjeto(ObjetoDto objetoDto) {
        return modelFactory.actualizarObjeto(objetoDto);
    }

    public boolean eliminarObjeto(String idObjeto) {return modelFactory.eliminarObjeto(idObjeto);}
}
