package co.edu.uniquindio.parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.controller.*;
import co.edu.uniquindio.parcial2.mapping.dto.ClienteDto;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import co.edu.uniquindio.parcial2.mapping.dto.*;
import co.edu.uniquindio.parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.mapping.dto.ClienteDto;
import co.edu.uniquindio.parcial2.mapping.dto.PrestamoDto;
import co.edu.uniquindio.parcial2.model.Prestamo;
import co.edu.uniquindio.parcial2.model.PrestamoObjeto;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrestamoAppController {
PrestamoController prestamoController;
ClienteController clienteController;
ObjetoController objetoController;
ObservableList<PrestamoDto> listaPrestamos= FXCollections.observableArrayList();
PrestamoDto prestamoSeleccionado;
EmpleadoController empleadoController;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarPrestamo;

    @FXML
    private Button btnAgregarPrestamo;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevoPrestamo;

    @FXML
    private ComboBox<ClienteDto> cmbClientes;

    @FXML
    private ComboBox<EmpleadoDto> cmbEmpleado;

    @FXML
    private ComboBox<ObjetoDto> cmbObjeto;

    @FXML
    private DatePicker dataFechaEntrega;

    @FXML
    private DatePicker dataFechaPrestamo;

    @FXML
    private TableView<PrestamoDto> tablePrestamos;

    @FXML
    private TableColumn<PrestamoDto, String> tcClienteAsociado;

    @FXML
    private TableColumn<PrestamoDto, String> tcDescripcion;

    @FXML
    private TableColumn<PrestamoDto, String> tcEmpleadoAsociado;

    @FXML
    private TableColumn<PrestamoDto, LocalDate> tcFechaEntrega;

    @FXML
    private TableColumn<PrestamoDto, LocalDate> tcFechaPrestamo;

    @FXML
    private TableColumn<PrestamoDto, String> tcNumeroPrestamo;

    @FXML
    private TableColumn<PrestamoDto, String> tcObjeto;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtNumeroPrestamo;

    @FXML
    void initialize() {
        prestamoController = new PrestamoController();
        clienteController = new ClienteController();
        objetoController = new ObjetoController();
        empleadoController = new EmpleadoController();
        initView();
        initComboboxes();
        configurarComboBoxes();
    }
    private void initComboboxes() {
        cmbClientes.setItems(FXCollections.observableArrayList(clienteController.obtenerClientes()));
        cmbEmpleado.setItems(FXCollections.observableArrayList(empleadoController.obtenerEmpleados()));
       cmbObjeto.setItems(FXCollections.observableArrayList(objetoController.obtenerObjetos()));
    }
    @FXML
    void onActualizarPrestamo(ActionEvent event) {
        if (prestamoSeleccionado != null) {
            PrestamoDto actualizado = new PrestamoDto(
                    txtNumeroPrestamo.getText(),
                    dataFechaPrestamo.getValue(),
                    dataFechaEntrega.getValue(),
                    txtDescripcion.getText(),
                    cmbEmpleado.getValue(),
                    List.of(cmbObjeto.getValue()),
                    cmbClientes.getValue()
            );

            if (datosValidos(actualizado)) {
                int index = listaPrestamos.indexOf(prestamoSeleccionado);
                listaPrestamos.set(index, actualizado);
                prestamoController.actualizarPrestamo(actualizado);
                limpiarFormulario();
            } else {
                mostrarAlerta("Datos inválidos para actualizar", javafx.scene.control.Alert.AlertType.ERROR);
            }
        }
    }


    @FXML
    void onAgregarPrestamo(ActionEvent event) {
        PrestamoDto nuevoPrestamo = new PrestamoDto(
                txtNumeroPrestamo.getText(),
                dataFechaPrestamo.getValue(),
                dataFechaEntrega.getValue(),
                txtDescripcion.getText(),
                cmbEmpleado.getValue(),
                List.of(cmbObjeto.getValue()),
                cmbClientes.getValue()
        );

        if (datosValidos(nuevoPrestamo)) {
            listaPrestamos.add(nuevoPrestamo);
            prestamoController.agregarPrestamo(nuevoPrestamo);
            limpiarFormulario();
        } else {
            mostrarAlerta("Datos inválidos para el préstamo", javafx.scene.control.Alert.AlertType.ERROR);
        }
    }


    @FXML
    void onEliminarPrestamo(ActionEvent event) {
        if (prestamoSeleccionado != null) {
            listaPrestamos.remove(prestamoSeleccionado);
            prestamoController.eliminarPrestamo(prestamoSeleccionado.numeroPrestamo());
            limpiarFormulario();
        } else {
            mostrarAlerta("Selecciona un préstamo para eliminar", javafx.scene.control.Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onFechaEntregaPrestamo(ActionEvent event) {

    }

    @FXML
    void onFechaPrestamo(ActionEvent event) {

    }

    @FXML
    void onListaClientes(ActionEvent event) {

    }

    @FXML
    void onListaEmpleado(ActionEvent event) {

    }

    @FXML
    void onListaObjetos(ActionEvent event) {

    }

    @FXML
    void onNuevoPrestamo(ActionEvent event) {
    //nuevoPrestamo();
    }


 private void initView(){
        initDataBinding();
        obtenerPrestamo();
        tablePrestamos.getItems().clear();
        tablePrestamos.setItems(listaPrestamos);
        listenerSelection();
 }
 private void obtenerPrestamo(){
        listaPrestamos.addAll(prestamoController.obtenerPrestamos());
 }
private void initDataBinding(){
    tcClienteAsociado.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getNombreCliente()));
    tcObjeto.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getNombreObjeto()));
    tcNumeroPrestamo.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().numeroPrestamo()));
    tcFechaEntrega.setCellValueFactory(cellData ->
            new SimpleObjectProperty<>(cellData.getValue().fechaEntrega()));
    tcFechaPrestamo.setCellValueFactory(cellData ->
            new SimpleObjectProperty<>(cellData.getValue().fechaPrestamo()));
    tcDescripcion.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().descripcion()));
    tcEmpleadoAsociado.setCellValueFactory(cellData ->
            new SimpleStringProperty(cellData.getValue().getNombreEmpleado()));

}
private void listenerSelection() {
    tablePrestamos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newSelection) -> {
        prestamoSeleccionado = newSelection;
        mostrarInformacionPrestamo(prestamoSeleccionado);
    });
}

    private boolean datosValidos(PrestamoDto prestamoDto) {
        if (prestamoDto.numeroPrestamo().isBlank() ||
                prestamoDto.fechaPrestamo().isAfter(LocalDate.now()) ||
                prestamoDto.fechaEntrega().isBefore(prestamoDto.fechaPrestamo()) ||
                prestamoDto.descripcion().isBlank() ||
                prestamoDto.empleadoAsociado() == null ||
                prestamoDto.listaObjetosAsociados().isEmpty() ||
                prestamoDto.ownedByPrestamoUq() == null) {
            return false;
        } else {
            return true;
        }
    }

    private void mostrarInformacionPrestamo(PrestamoDto prestamoSeleccionado) {
        if (prestamoSeleccionado != null) {
            txtDescripcion.setText(prestamoSeleccionado.descripcion());
            txtNumeroPrestamo.setText(prestamoSeleccionado.numeroPrestamo());
        }
    }
    private void configurarComboBoxes() {
        // Configurar ComboBox de Clientes
        cmbClientes.setCellFactory(lv -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(ClienteDto cliente, boolean empty) {
                super.updateItem(cliente, empty);
                setText(empty || cliente == null ? null : cliente.nombre());
            }
        });
        cmbClientes.setButtonCell(cmbClientes.getCellFactory().call(null));

        // Configurar ComboBox de Objetos
        cmbObjeto.setCellFactory(lv -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(ObjetoDto objeto, boolean empty) {
                super.updateItem(objeto, empty);
                setText(empty || objeto == null ? null : objeto.nombreObjeto());
            }
        });
        cmbObjeto.setButtonCell(cmbObjeto.getCellFactory().call(null));

        // Configurar ComboBox de Empleados
        cmbEmpleado.setCellFactory(lv -> new javafx.scene.control.ListCell<>() {
            @Override
            protected void updateItem(EmpleadoDto empleado, boolean empty) {
                super.updateItem(empleado, empty);
                setText(empty || empleado == null ? null : empleado.nombre()); // ← Aquí está el cambio
            }
        });
        cmbEmpleado.setButtonCell(cmbEmpleado.getCellFactory().call(null));
    }
private void limpiarFormulario() {
    txtNumeroPrestamo.clear();
    txtDescripcion.clear();
    dataFechaPrestamo.setValue(null);
    dataFechaEntrega.setValue(null);
    cmbClientes.setValue(null);
    cmbObjeto.setValue(null);
    prestamoSeleccionado = null;
}
    private void mostrarAlerta(String mensaje, javafx.scene.control.Alert.AlertType tipo) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(tipo);
        alert.setContentText(mensaje);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}


