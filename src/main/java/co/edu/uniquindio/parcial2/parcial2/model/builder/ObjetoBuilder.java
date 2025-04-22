package co.edu.uniquindio.parcial2.parcial2.model.builder;

import co.edu.uniquindio.parcial2.parcial2.model.Objeto;

public class ObjetoBuilder {
    private String nombre;
    private String idObjeto;

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getIdObjeto() {return idObjeto;}
    public void setIdObjeto(String idObjeto) {this.idObjeto = idObjeto;}

    public Objeto build() {
        return new Objeto(nombre, idObjeto);
    }

}
