package co.edu.uniquindio.parcial2.parcial2.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class AdministradorViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnMostrarObjeto;

    @FXML
    private TableView<?> tableObjetos;

    @FXML
    private TableColumn<?, ?> tcCodigoObjeto;

    @FXML
    private TableColumn<?, ?> tcDisponibilidad;

    @FXML
    private TableColumn<?, ?> tcNombreObjeto;

    @FXML
    private TableColumn<?, ?> tcRangoobjeto;

    @FXML
    private TextField txtcodigoObjeto;

    @FXML
    private TextField txtrangofinal;

    @FXML
    private TextField txtrangoinicial;

    @FXML
    void onMostrarObjeto(ActionEvent event) {

    }

    @FXML
    void initialize() {
    }
}
