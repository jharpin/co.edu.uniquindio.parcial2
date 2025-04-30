package co.edu.uniquindio.parcial2.factoryMethod.factory;

import co.edu.uniquindio.parcial2.factoryMethod.model.SistemaGestion;

public abstract class SistemaGestionFactory {
    public abstract SistemaGestion getSistemaGestionFabrica(String tipo);

}
