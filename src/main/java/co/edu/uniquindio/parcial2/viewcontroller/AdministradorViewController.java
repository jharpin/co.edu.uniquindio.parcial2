package co.edu.uniquindio.parcial2.viewcontroller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.mapping.dto.ObjetoDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdministradorViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnMostrarObjeto;

    @FXML
    private RadioButton rbConPrestamo;

    @FXML
    private RadioButton rbSinPrestamo;

    @FXML
    private RadioButton rbTodos;

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
    /*
    @FXML
    void onMostrarObjeto(ActionEvent event) {


        List<ObjetoDto> objetosFiltrados;

        if (rbConPrestamo.isSelected()) {
            objetosFiltrados = modelFactoryController.obtenerObjetosConPrestamo();
        } else if (rbSinPrestamo.isSelected()) {
            objetosFiltrados = modelFactoryController.obtenerObjetosSinPrestamo();
        } else {
            objetosFiltrados = modelFactoryController.obtenerTodosLosObjetos(); // todos
        }

        ObservableList<ObjetoDto> lista = FXCollections.observableArrayList(objetosFiltrados);
        tableObjetos.setItems(lista);

    }
*/
    @FXML
    void initialize() {
        tcCodigoObjeto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idObjeto()));
        tcNombreObjeto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreObjeto()));
        // Solo si tienes disponibilidad y rango en ObjetoDto
        // tcDisponibilidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().disponibilidad()));
        // tcRangoobjeto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().rango()));

    }
    private void mostrarObjetosPorRangoAntiguedad() {
       /* try {
            int rangoInicial = Integer.parseInt(txtrangoinicial.getText());
            int rangoFinal = Integer.parseInt(txtrangofinal.getText());

            List<ObjetoDto> objetosFiltrados = modelFactoryController.obtenerTodosLosObjetos()
                    .stream()
                    .filter(objeto -> {
                        int anioObjeto = Integer.parseInt(objeto.anioCreacion()); // ← ajustamos si el campo se llama distinto
                        return anioObjeto >= rangoInicial && anioObjeto <= rangoFinal;
                    })
                    .toList();

            ObservableList<ObjetoDto> lista = FXCollections.observableArrayList(objetosFiltrados);
            tableObjetos.setItems(lista);

        } catch (NumberFormatException e) {
            System.out.println("Error al leer los rangos: deben ser números");
        }
    }*/
    }

}
