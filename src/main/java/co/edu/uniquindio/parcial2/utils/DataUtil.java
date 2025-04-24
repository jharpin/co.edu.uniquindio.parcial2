package co.edu.uniquindio.parcial2.utils;

import co.edu.uniquindio.parcial2.model.*;
import co.edu.uniquindio.parcial2.model.PrestamoObjeto;

public class DataUtil {

    public static PrestamoObjeto inicializarDatos() {
        PrestamoObjeto prestamoObjeto = new PrestamoObjeto();
        Cliente cliente1 = Cliente.builder()
                .cedula("1094")
                .nombre("juan")
                .apellido("arias")
                .direccion("armenia")
                .edad(17)
                .email("jsjsj@gmail.com")
                .build();

        Cliente cliente2 = Cliente.builder()
                .cedula("1095")
                .nombre("Ana")
                .apellido("cardenas")
                .direccion("quimbaya")
                .edad(25)
                .email("jsjsj2@gmail.com")
                .build();

        Cliente cliente3 = Cliente.builder()
                .cedula("1096")
                .nombre("Pedro")
                .apellido("perez")
                .direccion("armenia")
                .edad(40)
                .email("jsjsj3@gmail.com")
                .build();

        Objeto objeto = Objeto.builder()
                .nombreObjeto("carro")
                .idObjeto("678")
                .build();

        Objeto objeto1 = Objeto.builder()
                .nombreObjeto("motos")
                .idObjeto("777")
                .build();
        Objeto objeto2 = Objeto.builder()
                .idObjeto("888")
                .nombreObjeto("casas")
                .build();

        prestamoObjeto.getListaObjetos().add(objeto);
        prestamoObjeto.getListaObjetos().add(objeto1);
        prestamoObjeto.getListaObjetos().add(objeto2);
        prestamoObjeto.getListaClientes().add(cliente1);
        prestamoObjeto.getListaClientes().add(cliente2);
        prestamoObjeto.getListaClientes().add(cliente3);

        return prestamoObjeto;
    }
}
