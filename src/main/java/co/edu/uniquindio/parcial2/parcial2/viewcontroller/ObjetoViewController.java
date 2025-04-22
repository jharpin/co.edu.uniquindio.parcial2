package co.edu.uniquindio.parcial2.parcial2.viewcontroller;
import co.edu.uniquindio.parcial2.parcial2.controller.ObjetoController;
import co.edu.uniquindio.parcial2.parcial2.mapping.dto.ClienteDto;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.parcial2.mapping.dto.ObjetoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.parcial2.parcial2.utils.PrestamoConstantes.*;

public class ObjetoViewController {
    ObservableList<ObjetoDto> listaObjetos = FXCollections.observableArrayList();
    ObjetoController objetoController;
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
    private TableView<?> tableObjetos;

    @FXML
    private TableColumn<?, ?> tcCodigoObjeto;

    @FXML
    private TableColumn<?, ?> tcNombreObjeto;

    @FXML
    private TextField txtCodigoObjeto;

    @FXML
    private TextField txtNombreObjeto;

    @FXML
    void onActualizarObjeto(ActionEvent event) {
        //actualizarObjeto();

    }

    @FXML
    void onAgregarObjeto(ActionEvent event) {
       agregarObjeto();

    }

    @FXML
    void onEliminarObjeto(ActionEvent event) {
        // eliminarObjeto();

    }

    @FXML
    void onNuevoObjeto(ActionEvent event) {

    }

    @FXML
    void initialize() {
       ObjetoController objetoController  = new ObjetoController();
        initView();
    }
    private void initView() {
        //initDataBinding();
        tableObjetos.getItems().clear();
        //tableObjetos.setItems(listaObjetos());
        //listenerSelection();
    }

    private void agregarObjeto() {
        ObjetoDto objetoDto = crearObjetoDto();
        if(datosValidos(objetoDto)){
            if(objetoController.agregarObjeto(objetoDto)){
                listaObjetos.addAll(objetoDto);
                limpiarCampos();
                mostrarMensaje(TITULO_CLIENTE_AGREGADO, HEADER, BODY_CLIENTE_AGREGADO, Alert.AlertType.INFORMATION);
            }else{
                mostrarMensaje(TITULO_CLIENTE_NO_AGREGADO, HEADER, BODY_CLIENTE_NO_AGREGADO,Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO,Alert.AlertType.WARNING);
        }
    }
    private ObjetoDto crearObjetoDto() {
        return new ObjetoDto(
                txtNombreObjeto.getText(),
                txtCodigoObjeto.getText());
    }
    private boolean datosValidos(ObjetoDto objetoDto) {
        if(objetoDto.nombre().isBlank() ||
                objetoDto.idObjeto().isBlank()

        ){
            return false;
        }else{
            return true;
        }
    }
    private void limpiarCampos() {
        txtNombreObjeto.setText("");
        txtCodigoObjeto.setText("");

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
