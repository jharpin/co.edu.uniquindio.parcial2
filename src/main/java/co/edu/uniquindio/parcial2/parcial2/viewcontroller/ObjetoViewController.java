package co.edu.uniquindio.parcial2.parcial2.viewcontroller;
import co.edu.uniquindio.parcial2.parcial2.controller.ObjetoController;
import co.edu.uniquindio.parcial2.parcial2.mapping.dto.ClienteDto;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.parcial2.mapping.dto.ObjetoDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ObjetoViewController {
    ObservableList<ObjetoDto> listaObjetos = FXCollections.observableArrayList();

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
        actualizarObjeto();

    }

    @FXML
    void onAgregarObjeto(ActionEvent event) {
       agregarObjeto();

    }

    @FXML
    void onEliminarObjeto(ActionEvent event) {
        eliminarObjeto();

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
        initDataBinding();
        tableObjetos.getItems().clear();
        tableObjetos.setItems(listaObjetos());
        listenerSelection();
    }

}
