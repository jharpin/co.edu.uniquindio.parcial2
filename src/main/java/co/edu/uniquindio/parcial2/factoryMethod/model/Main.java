package co.edu.uniquindio.parcial2.factoryMethod.model;

public class Main {
    public static void main(String[] args) {

       AplicacionFabrica aplifabrica  = new AplicacionFabrica();

        AplicacionMovil apliMovil = aplifabrica.getAplicacionMovil("AplicacionMovilIOs");

        apliMovil.mostrarInformacion();

        SistemasGestionFabrica sistemfabrica  = new SistemasGestionFabrica();

       SistemaGestion sistema = sistemfabrica.getSistemasGestion("SistemasCRM");

        sistema.gestionarSistemas();
    }
}

