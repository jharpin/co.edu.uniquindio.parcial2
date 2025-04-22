package co.edu.uniquindio.parcial2.parcial2.model.builder;

import co.edu.uniquindio.parcial2.parcial2.model.Objeto;

public class ObjetoBuilder {
    protected String nombreObjeto;
    protected String idObjeto;

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObejto(String nombre) {
        this.nombreObjeto= nombre;
    }

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public Objeto build() {
        return new Objeto(nombreObjeto, idObjeto);
    }

}
