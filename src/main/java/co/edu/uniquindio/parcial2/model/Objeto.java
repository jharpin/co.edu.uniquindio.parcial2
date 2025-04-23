package co.edu.uniquindio.parcial2.model;

import co.edu.uniquindio.parcial2.model.builder.ObjetoBuilder;

public class Objeto {
    private String nombreObjeto;
    private String idObjeto;
    PrestamoObjeto ownedByPrestamoUq;

    public Objeto() {
    }

    public Objeto(String nombre, String idObjeto) {
        this.nombreObjeto = nombreObjeto;
        this.idObjeto = idObjeto;
    }

    public Objeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public String getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }
    public static ObjetoBuilder builder(){
        return new ObjetoBuilder();
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombreObjeto + '\'' +
                ", idObjeto='" + idObjeto + '\'' +
                '}';
    }
}
