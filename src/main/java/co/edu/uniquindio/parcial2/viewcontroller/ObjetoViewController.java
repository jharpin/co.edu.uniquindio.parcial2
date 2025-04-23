package co.edu.uniquindio.parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.controller.ObjetoController;
import co.edu.uniquindio.parcial2.mapping.dto.ObjetoDto;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.parcial2.utils.PrestamoConstantes.*;

public class ObjetoViewController {

    ObjetoController objetoController;
    ObservableList<ObjetoDto> listaObjetos = FXCollections.observableArrayList();
    ObjetoDto objetoSeleccionado;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarObjeto;

    @FXML
    private Button btnAgregarObjeto;

    @FXML
    private Button btnEliminarObjeto;

    @FXML
    private Button btnNuevoObjeto;

    @FXML
    private TableView<ObjetoDto> tableObjetos;

    @FXML
    private TableColumn<ObjetoDto, String> tcCodigoObjeto;

    @FXML
    private TableColumn<ObjetoDto, String> tcNombreObjeto;

    @FXML
    private TextField txtCodigoObjeto;

    @FXML
    private TextField txtNombreObjeto;

    @FXML
    void initialize() {
        objetoController = new ObjetoController();
        initView();
    }
    @FXML
    void onAgregarObjeto(ActionEvent event) {agregarObjeto();}

    @FXML
    void onEliminarObjeto(ActionEvent event) {eliminarObjeto();}

    @FXML
    void onActualizarObjeto(ActionEvent event) {
        //actualizarObjeto();
    }

    @FXML
    void onNuevoObjeto(ActionEvent event) {nuevoObjeto();}


    private void initView() {
        initDataBinding();
        obtenerObjeto();
        tableObjetos.getItems().clear();
        tableObjetos.setItems(listaObjetos);
        listenerSelection();

    }

    private void obtenerObjeto() {
        listaObjetos.addAll(objetoController.obtenerObjetos());
    }

    private void initDataBinding() {
      tcNombreObjeto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreObjeto()));
      tcCodigoObjeto.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().idObjeto()));
    }

    private void listenerSelection(){
        tableObjetos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            objetoSeleccionado = newSelection;
            mostrarInformacionObjeto(objetoSeleccionado);
        });
    }

    private void agregarObjeto() {
        ObjetoDto objetoDto = crearObjetoDto();
        if(datosValidos(objetoDto)){
            if(objetoController.agregarObjeto(objetoDto)){
                listaObjetos.addAll(objetoDto);
                limpiarCampos();
                mostrarMensaje(TITULO_OBJETO_AGREGADO, HEADER, BODY_CLIENTE_AGREGADO, Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje(TITULO_OBJETO_NO_AGREGADO, HEADER, BODY_CLIENTE_NO_AGREGADO,Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO,Alert.AlertType.WARNING);
        }
    }

    private void eliminarObjeto() {
        if(objetoSeleccionado != null) {
            if (objetoController.eliminarObjeto(objetoSeleccionado.idObjeto())) {
                listaObjetos.remove(objetoSeleccionado);
                limpiarCampos();
            }
        }
    }
    private void nuevoObjeto() {
        limpiarCampos();
        txtNombreObjeto.setText("ingrese el nuevo objeto");
    }

    private void limpiarCampos() {
        txtNombreObjeto.setText("");
        txtCodigoObjeto.setText("");

    }
    private ObjetoDto crearObjetoDto() {
        return new ObjetoDto(
                txtNombreObjeto.getText(),
                txtCodigoObjeto.getText());
    }
    private boolean datosValidos(ObjetoDto objetoDto) {
        if(objetoDto.nombreObjeto().isBlank() ||
                objetoDto.idObjeto().isBlank()

        ){
            return false;
        }else{
            return true;
        }
    }


    private void mostrarInformacionObjeto(ObjetoDto objetoSeleccionado) {
        if(objetoSeleccionado != null){
            txtNombreObjeto.setText(objetoSeleccionado.nombreObjeto());
            txtCodigoObjeto.setText(objetoSeleccionado.idObjeto());
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }


    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }


   /** private void eliminarObjeto() {
        if(ObjetoSeleccionado != null){
            if(objetoController.eliminarObjeto(ObjetoSeleccionado.idObjeto())){
                listaObjetos.remove(objetoSeleccionado);
                limpiarCampos();
                mostrarMensaje(TITULO_CLIENTE_ELIMINADO, HEADER, BODY_CLIENTE_AGREGADO,Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje(TITULO_CLIENTE_NO_AGREGADO, HEADER, BODY_CLIENTE_NO_AGREGADO,Alert.AlertType.ERROR);
            }
        }
    }**/


}
