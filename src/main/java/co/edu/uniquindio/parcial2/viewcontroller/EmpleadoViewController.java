package co.edu.uniquindio.parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.factory.EmpleadoFactory;
import co.edu.uniquindio.parcial2.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class EmpleadoViewController {

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
    private MenuButton menuTipoEmpleado;

    @FXML
    private TableView<Empleado> tableEmpleado;

    @FXML
    private TableColumn<Empleado, String> tcApellido;

    @FXML
    private TableColumn<Empleado, String> tcCedula;

    @FXML
    private TableColumn<Empleado, String> tcDireccion;

    @FXML
    private TableColumn<Empleado, String>   tcTipoEmpleado;

    @FXML
    private TableColumn<Empleado, String> tcEmail;

    @FXML
    private TableColumn<Empleado, String> tcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtdireccion;

    // 🔵 Lista para manejar los empleados
    private ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();

    // 🔵 Tipo de empleado seleccionado (por defecto "Permanente")
    private String tipoEmpleadoSeleccionado = "Permanente";

    @FXML
    void initialize() {
        // Configurar menú de tipo empleado
        MenuItem itemPermanente = new MenuItem("Permanente");
        MenuItem itemTemporal = new MenuItem("Temporal");

        itemPermanente.setOnAction(e -> {
            menuTipoEmpleado.setText("Permanente");
            tipoEmpleadoSeleccionado = "Permanente";
        });

        itemTemporal.setOnAction(e -> {
            menuTipoEmpleado.setText("Temporal");
            tipoEmpleadoSeleccionado = "Temporal";
        });

        menuTipoEmpleado.getItems().addAll(itemPermanente, itemTemporal);

        // Configurar columnas
        configurarTabla();

        // Enlazar lista con la tabla
        tableEmpleado.setItems(listaEmpleados);
    }

    private void configurarTabla() {
        tcCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tcNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tcApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));  // Debes tener getter de email
        tcDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion")); // Debes tener getter de direccion
        tcTipoEmpleado.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(cellData.getValue().getTipo())
        );
    }

    @FXML
    void onAgregarCliente(ActionEvent event) {
        String cedula = txtCedula.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String email = txtEmail.getText();
        String direccion = txtdireccion.getText();

        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
            mostrarAlerta("Error", "Por favor complete todos los campos obligatorios.");
            return;
        }

        try {
            Empleado empleado = EmpleadoFactory.crearEmpleado(
                    tipoEmpleadoSeleccionado.toLowerCase(),
                    cedula,
                    nombre,
                    apellido,
                    0 // Edad la dejamos como 0 por ahora porque tu formulario no pide edad
            );

            // 🔵 Aquí tendrías que setear el email y dirección manualmente si Empleado permite setEmail y setDireccion
            empleado.setEmail(email);
             empleado.setDireccion(direccion);

            listaEmpleados.add(empleado);
            limpiarCampos();
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo agregar el empleado: " + e.getMessage());
        }
    }

    @FXML
    void onEliminarCliente(ActionEvent event) {
        Empleado seleccionado = tableEmpleado.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaEmpleados.remove(seleccionado);
        } else {
            mostrarAlerta("Advertencia", "Seleccione un empleado para eliminar.");
        }
    }

    @FXML
    void onActualizarCliente(ActionEvent event) {
        Empleado seleccionado = tableEmpleado.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setApellido(txtApellido.getText());
            seleccionado.setCedula(txtCedula.getText());
            // seleccionado.setEmail(txtEmail.getText()); // Si tienes método setEmail
            // seleccionado.setDireccion(txtdireccion.getText()); // Si tienes método setDireccion

            tableEmpleado.refresh();
            limpiarCampos();
        } else {
            mostrarAlerta("Advertencia", "Seleccione un empleado para actualizar.");
        }
    }

    @FXML
    void onNuevoCliente(ActionEvent event) {
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtCedula.clear();
        txtNombre.clear();
        txtApellido.clear();
        txtEmail.clear();
        txtdireccion.clear();
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}