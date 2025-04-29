package co.edu.uniquindio.parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.controller.EmpleadoController;
import co.edu.uniquindio.parcial2.mapping.dto.EmpleadoDto;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.model.Empleado;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.parcial2.utils.PrestamoConstantes.*;

public class EmpleadoViewController {

    EmpleadoController empleadoController;
    ObservableList<EmpleadoDto> listaempleados= FXCollections.observableArrayList();
    EmpleadoDto empleadoSeleccionado;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevo;

    @FXML
    private TableView<EmpleadoDto> tableEmpleado;

    @FXML
    private TableColumn<EmpleadoDto, String> tcApellido;

    @FXML
    private TableColumn<EmpleadoDto, String> tcCedula;

    @FXML
    private TableColumn<EmpleadoDto, String> tcDireccion;

    @FXML
    private TableColumn<EmpleadoDto, Integer> tcEdad;

    @FXML
    private TableColumn<EmpleadoDto, String> tcEmail;

    @FXML
    private TableColumn<EmpleadoDto, String > tcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtdireccion;

    @FXML
    void initialize() {
    empleadoController=new EmpleadoController();
    initView();
    restringirEdadSoloNumeros();
    }
    @FXML
    void onActualizarEmpleado(ActionEvent event) {
        actualizarEmpleado();
    }

    @FXML
    void onAgregarEmpelado(ActionEvent event) {
    agregarEmpleado();
    }

    @FXML
    void onEliminarEmpleado(ActionEvent event) {eliminarEmpleado();
    }

    @FXML
    void onNuevoEmpleado(ActionEvent event) {
    nuevoEmpleado();
    }
    private void initView() {
        initDataBinding();
        obtenerEmpleados();
        tableEmpleado.getItems().clear();
        tableEmpleado.setItems(listaempleados);
        listenerSelection();
    }
    private void obtenerEmpleados() {listaempleados.addAll(empleadoController.obtenerEmpleados());}

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().apellido()));
        tcCedula.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().cedula()));
        tcEmail.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().correo()));
        tcDireccion.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().direccion()));
        tcEdad.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().edad()).asObject());
    }
    private void listenerSelection() {
        tableEmpleado.getSelectionModel().selectedItemProperty().addListener((obs, oldSelecion, newSelection) -> {
            empleadoSeleccionado = newSelection;
            mostrarInformacionEmpleado(empleadoSeleccionado);
        });
    }
    private void agregarEmpleado() {
        EmpleadoDto empleadoDto=crearEmpleadoDto();
        if(datosValidos(empleadoDto)) {
            if(empleadoController.agregarEmpleado(empleadoDto)) {
                listaempleados.add(empleadoDto);
                limpiarCampos();
                mostrarMensaje("EMPLEADO AGREGADO",HEADER,"EMPLEADO AGREGADO CON EXITO",Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje("EMPLEADO NO AGREGADO",HEADER,"EMPLEADO NO AGREGADO",Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO,Alert.AlertType.WARNING);
        }
    }
    private void actualizarEmpleado() {
        if (empleadoSeleccionado!=null){
            EmpleadoDto empleadoActualizado=crearEmpleadoDto();
            if(datosValidos(empleadoActualizado)) {
                if(empleadoController.actualizarEmpleado(empleadoActualizado)) {
                    for(EmpleadoDto empleado:listaempleados){
                        if(empleado.equals(empleadoSeleccionado)) {
                            listaempleados.remove(empleado);
                            listaempleados.add(empleadoActualizado);
                            break;
                        }
                    }
                    mostrarMensaje("Empleado Actualizado",HEADER,"Empleado Actualizado",Alert.AlertType.INFORMATION);
                }else{mostrarMensaje("EMPLEADO NO ACTUALIZADO",HEADER,"Empleado NO ACTUALIZADO",Alert.AlertType.ERROR);}
            }else{mostrarMensaje("DATOS NO COMPLETADOS",HEADER,"DATOS NO COMPLETADOS",Alert.AlertType.ERROR);}
        }
    }
    private void eliminarEmpleado() {
        if(empleadoSeleccionado!=null) {
            if(empleadoController.eliminarEmpleado(empleadoSeleccionado.cedula())){
                listaempleados.remove(empleadoSeleccionado);
                limpiarCampos();
                mostrarMensaje("Empleado eliminado",HEADER,"empleado eliminado",Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje("empleado no eliminado",HEADER,"empleado no eliminado",Alert.AlertType.ERROR);
            }
        }
    }
    private void nuevoEmpleado() {
        limpiarCampos();
        txtNombre.setText("ingrese nombre");
    }
    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEmail.setText("");
        txtEdad.setText("");
        txtdireccion.setText("");
    }
    private EmpleadoDto crearEmpleadoDto() {
        return new EmpleadoDto(
                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtdireccion.getText(),
                txtEmail.getText(),
                Integer.parseInt(txtEdad.getText()) );
    }
    private boolean datosValidos(EmpleadoDto empleadoDto) {
        if(empleadoDto.nombre().isBlank()||
        empleadoDto.apellido().isBlank()||
        empleadoDto.cedula().isBlank()||
        empleadoDto.correo().isBlank()||
        empleadoDto.direccion().isBlank()||
                empleadoDto.edad()<= 0
    ){
    return false;
    }else{
        return true;
    }
}
    private void mostrarInformacionEmpleado(EmpleadoDto empleadoSeleccionado) {
        if(empleadoSeleccionado!=null){
            txtNombre.setText(empleadoSeleccionado.nombre());
            txtApellido.setText(empleadoSeleccionado.apellido());
            txtCedula.setText(empleadoSeleccionado.cedula());
            txtEmail.setText(empleadoSeleccionado.correo());
            txtdireccion.setText(empleadoSeleccionado.direccion());
            txtEdad.setText(String.valueOf(empleadoSeleccionado.edad()));
        }
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private void restringirEdadSoloNumeros() {
        txtEdad.setTextFormatter(new TextFormatter<>(change -> {
            String nuevoTexto = change.getControlNewText();
            if (nuevoTexto.matches("\\d*")) {
                return change; // Permite solo números
            } else {
                return null; // Rechaza letras o símbolos
            }
        }));
    }
}
