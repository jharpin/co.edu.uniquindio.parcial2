package co.edu.uniquindio.parcial2.parcial2.controller;

import co.edu.uniquindio.parcial2.parcial2.factory.ModelFactory;

public class ObjetoController {
    ModelFactory modelFactory;
    public ObjetoController(){
        modelFactory = ModelFactory.getInstancia();
    }
}
