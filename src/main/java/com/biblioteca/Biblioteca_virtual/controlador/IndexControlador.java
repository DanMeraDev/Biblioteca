package com.biblioteca.Biblioteca_virtual.controlador;

import com.biblioteca.Biblioteca_virtual.modelos.Persona;
import com.biblioteca.Biblioteca_virtual.modelos.Usuario;
import com.biblioteca.Biblioteca_virtual.repositorios.UsuarioRepository;
import com.biblioteca.Biblioteca_virtual.servicios.UsuarioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class IndexControlador implements Initializable {
    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    private UsuarioService usuarioService;

    @FXML
    private TableView<Usuario> usuarioTabla;

    @FXML
    private TableColumn<Usuario, Long> idUsuarioColumna;

    @FXML
    private TableColumn<Usuario, String> nombreUsuarioColumna;

    @FXML
    private TableColumn<Usuario, String> correoUsuarioColumna;

    @FXML
    private TableColumn<Usuario, String> dniUsuarioColumna;

    @FXML
    private TableColumn<Usuario, String> celularUsuarioColumna;

    @FXML
    private TableColumn<Usuario, String> facultadUsuarioColumna;

    private final ObservableList<Usuario> usuariosList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuarioTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configurarColumnas();
        listarTareas();
    }

    private void configurarColumnas() {
        idUsuarioColumna.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreUsuarioColumna.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        correoUsuarioColumna.setCellValueFactory(new PropertyValueFactory<>("correo"));
        dniUsuarioColumna.setCellValueFactory(new PropertyValueFactory<>("docIdentidad"));
        celularUsuarioColumna.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        facultadUsuarioColumna.setCellValueFactory(new PropertyValueFactory<>("facultad"));

    }

    private void listarTareas() {
        usuariosList.clear();
        usuarioService.obtenerUsuarios().stream()
                        .filter(persona -> persona instanceof Usuario)
                        .map(persona -> (Usuario)persona)
                        .forEach(usuariosList::add);
        usuarioTabla.setItems(usuariosList);
    }
}
