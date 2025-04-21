package co.edu.uniquindio.parcial2.parcial2.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ObjetoViewController {

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

    }

    @FXML
    void onAgregarObjeto(ActionEvent event) {

    }

    @FXML
    void onEliminarObjeto(ActionEvent event) {

    }

    @FXML
    void onNuevoObjeto(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnActualizarObjeto != null : "fx:id=\"btnActualizarObjeto\" was not injected: check your FXML file 'Objeto.fxml'.";
        assert btnAgregarObjeto != null : "fx:id=\"btnAgregarObjeto\" was not injected: check your FXML file 'Objeto.fxml'.";
        assert btnEliminarObjeto != null : "fx:id=\"btnEliminarObjeto\" was not injected: check your FXML file 'Objeto.fxml'.";
        assert btnNuevoObjeto != null : "fx:id=\"btnNuevoObjeto\" was not injected: check your FXML file 'Objeto.fxml'.";
        assert tableObjetos != null : "fx:id=\"tableObjetos\" was not injected: check your FXML file 'Objeto.fxml'.";
        assert tcCodigoObjeto != null : "fx:id=\"tcCodigoObjeto\" was not injected: check your FXML file 'Objeto.fxml'.";
        assert tcNombreObjeto != null : "fx:id=\"tcNombreObjeto\" was not injected: check your FXML file 'Objeto.fxml'.";
        assert txtCodigoObjeto != null : "fx:id=\"txtCodigoObjeto\" was not injected: check your FXML file 'Objeto.fxml'.";
        assert txtNombreObjeto != null : "fx:id=\"txtNombreObjeto\" was not injected: check your FXML file 'Objeto.fxml'.";

    }

}
