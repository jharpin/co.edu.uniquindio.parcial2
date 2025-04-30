package co.edu.uniquindio.parcial2.factoryMethod.model;

public class AplicacionFabrica {
    public static AplicacionMovil getAplicacionMovil(String tipo){
        if(tipo == null){
            return new AplicacionVacio();
        }
        if(tipo.equalsIgnoreCase("AplicacionMovilAndroid")){
            return new AplicacionMovilAndroid();
        }else if(tipo.equalsIgnoreCase("AplicacionMovilIOS")){
            return new AplicacionMovilIOs();
        }else if(tipo.equalsIgnoreCase("AplicacionMoviMultiplataforma")){
        return new AplicacionMultiplataforma();
    }
        return new AplicacionVacio();
    }

}
