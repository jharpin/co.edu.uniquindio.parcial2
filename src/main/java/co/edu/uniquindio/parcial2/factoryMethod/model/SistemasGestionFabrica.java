package co.edu.uniquindio.parcial2.factoryMethod.model;
import co.edu.uniquindio.parcial2.factoryMethod.factory.SistemaGestionFactory;

public class SistemasGestionFabrica {
    public static SistemaGestion getSistemasGestion(String tipo){
        if(tipo == null){
            return new SistemaGestionVacio();
        }
        if(tipo.equalsIgnoreCase("SistemasCRM")){
            return new SistemasCRM();
        }else if(tipo.equalsIgnoreCase("SistemasERP")){
            return new SistemasERP();
        }else if(tipo.equalsIgnoreCase("Sistemas Gestion Proyecto")){
            return new SistemasGestionProyectos();
        }
        return new SistemaGestionVacio();
    }


}
