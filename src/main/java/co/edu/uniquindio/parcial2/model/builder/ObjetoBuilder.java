package co.edu.uniquindio.parcial2.model.builder;

import co.edu.uniquindio.parcial2.model.Objeto;

public class ObjetoBuilder {
    protected String nombreObjeto;
    protected String idObjeto;

    public ObjetoBuilder nombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
        return this;
    }
    public ObjetoBuilder idObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
        return this;
    }

    public Objeto build() {
        return new Objeto(nombreObjeto, idObjeto);
    }

}
