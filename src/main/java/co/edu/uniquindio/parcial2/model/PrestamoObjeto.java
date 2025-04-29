package co.edu.uniquindio.parcial2.model;


import co.edu.uniquindio.parcial2.EjemploFactoryMethod.Controller.EmpleadoController;

import java.util.ArrayList;
import java.util.List;

public class PrestamoObjeto {

    List<Cliente> listaClientes = new ArrayList<>();
    List<EmpleadoController> listaEmpleados = new ArrayList<>();
    List<Empleado>listaEmpleados1 = new ArrayList<>();
    List<Objeto> listaObjetos = new ArrayList<>();
    List<Prestamo> listaPrestamos = new ArrayList<>();

    private String nombre;


    public PrestamoObjeto() {
    }


    public boolean crearCliente(String cedula,
                                String nombre,
                                String apellido,
                                String email,
                                String telefonoFijo,
                                String telefonoCelular,
                                String direccion) {
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if (clienteEncontrado == null) {
            Cliente cliente = getBuildCliente(cedula, nombre, apellido, email, telefonoFijo, telefonoCelular, direccion);
            getListaClientes().add(cliente);
            return true;
        } else {
            return false;
        }
    }

    public boolean crearCliente(Cliente nuevoCliente) {
        Cliente clienteEncontrado = obtenerCliente(nuevoCliente.getCedula());
        if (clienteEncontrado == null) {
            getListaClientes().add(nuevoCliente);
            return true;
        } else {
            return false;
        }
    }


    private Cliente getBuildCliente(String cedula, String nombre, String apellido, String email, String telefonoFijo, String telefonoCelular, String direccion) {
        return Cliente.builder()
                .nombre(nombre)
                .apellido(apellido)
                .cedula(cedula)
                .direccion(direccion)
                .email(email)
                .telefonoFijo(telefonoFijo)
                .telefonoCelular(telefonoCelular)
                .build();
    }

    private Cliente obtenerCliente(String cedula) {
        Cliente cliente = null;
        for (Cliente cliente1 : getListaClientes()) {
            if (cliente1.getCedula().equalsIgnoreCase(cedula)) {
                cliente = cliente1;
                break;
            }
        }

        return cliente;
    }


    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerClientesPorCiudad(String ciudad) {
        String resultado = "";

        for (Cliente cliente : getListaClientes()) {
            if (cliente.getDireccion().equalsIgnoreCase(ciudad)) {
                resultado = resultado + cliente.toString() + "\n";
            }
        }

        return resultado;
    }

    public boolean eliminarCliente(String cedula) {
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if (clienteEncontrado != null) {
            getListaClientes().remove(clienteEncontrado);
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarCliente(Cliente cliente) {
        Cliente clienteActual = obtenerCliente(cliente.getCedula());
        if (clienteActual != null) {
            clienteActual.setNombre(cliente.getNombre());
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setEmail(cliente.getEmail());
            clienteActual.setDireccion(cliente.getDireccion());
            return true;
        }
        return false;

    }
    public boolean actualizarObjeto(Objeto objeto) {
        Objeto objetoActual=obtenerObjeto(objeto.getIdObjeto());
        if(objetoActual!=null){
            objetoActual.setNombreObjeto(objeto.getNombreObjeto());
            objetoActual.setIdObjeto(objeto.getIdObjeto());
            return true;
        }
        return false;
    }
    public boolean actualizarPrestamo(Prestamo prestamo) {
        Prestamo prestamoActual=obtenerPrestamo(prestamo.getNumeroPrestamo());
        if(prestamoActual!=null){
            prestamoActual.setNumeroPrestamo(prestamo.getNumeroPrestamo());
            prestamoActual.setFechaPrestamo(prestamo.getFechaPrestamo());
            prestamoActual.setFechaEntrega(prestamo.getFechaEntrega());
            prestamoActual.setDescripcion(prestamo.getDescripcion());
            prestamoActual.setClienteAsociado(prestamo.getClienteAsociado());
            prestamoActual.setListaObjetosAsociados(prestamo.getListaObjetosAsociados());
            prestamoActual.setEmpleadoAsociado(prestamo.getEmpleadoAsociado());
            return true;
        }
        return false;
    }
    public List<Prestamo>getListaPrestamos() {
        return listaPrestamos;
    }
    public boolean crearPrestamo(Prestamo nuevoPrestamo) {
        Prestamo PrestamoEncontrado= obtenerPrestamo(nuevoPrestamo.getNumeroPrestamo());
        if (PrestamoEncontrado == null) {
            getListaPrestamos().add(nuevoPrestamo);
            return true;
        }else{
            return false;
        }
    }
    private Prestamo obtenerPrestamo(String numeroPrestamo) {
        Prestamo prestamo = null;
        for (Prestamo prestamo1 : getListaPrestamos()) {
            if (prestamo1.getNumeroPrestamo().equalsIgnoreCase(numeroPrestamo)) {
                prestamo = prestamo1;
                break;
            }
        }
        return prestamo;
    }

public boolean eliminarPrestamo(String numeroPrestamo) {
        Prestamo prestamoEncontrado= obtenerPrestamo(numeroPrestamo);
        if (prestamoEncontrado != null) {
            getListaPrestamos().remove(prestamoEncontrado);
            return true;
        }else{
            return false;
        }
    }
    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public boolean crearObjeto(Objeto nuevoObjeto) {
        Objeto objetoEncontrado = obtenerObjeto(nuevoObjeto.getIdObjeto());
        if (objetoEncontrado == null) {
            getListaObjetos().add(nuevoObjeto);
            return true;
        } else {
            return false;
        }
    }

    private Objeto obtenerObjeto(String idObjeto) {
        Objeto objeto=null;
        for (Objeto objeto1 : getListaObjetos()) {
            if (objeto1.getIdObjeto().equalsIgnoreCase(idObjeto)) {
               objeto = objeto1;
               break;
            }
        }
        return objeto;
    }

        public boolean eliminarObjeto(String idObjeto) {
        Objeto objetoEncontrado = obtenerObjeto(idObjeto);
        if (objetoEncontrado != null) {
            getListaObjetos().remove(objetoEncontrado);
            return true;
        } else {
            return false;
        }
    }

    // Listar empleados
   public List<EmpleadoController> listarEmpleados() {
        return listaEmpleados;
    }

    // Getter y Setter de listaEmpleados
    public List<EmpleadoController> getListaEmpleados() {
        return listaEmpleados;
    }




    public List<Empleado> listarEmpleados1() {
        return listaEmpleados1;
    }

    // Getter y Setter de listaEmpleados
    public List<Empleado> getListaEmpleados1() {
        return listaEmpleados1;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados1) {
        this.listaEmpleados1 = listaEmpleados1;
    }

}
