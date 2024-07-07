package com.biblioteca.Biblioteca_virtual.controlador;

import com.biblioteca.Biblioteca_virtual.modelos.Persona;
import com.biblioteca.Biblioteca_virtual.modelos.Usuario;
import com.biblioteca.Biblioteca_virtual.servicios.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class LoginControlador {

    @Autowired
    private UsuarioService usuarioService;


    @FXML
    private TextField usuarioLogin;

    @FXML
    private PasswordField passwordLogin;

    @FXML
    private CheckBox showPass;

    @FXML
    private Button loginButton;

    @FXML
    private MediaView mediaView;




    @FXML
    private void eventKey(KeyEvent event) {

    }

    @FXML
    private void accionIngresar(ActionEvent event) {
        Object eventSource = event.getSource();
        if (eventSource == loginButton) {
            if (!usuarioLogin.getText().isEmpty() && !passwordLogin.getText().isEmpty()) {

                String user = usuarioLogin.getText();
                String pass = passwordLogin.getText();

                Optional<Persona> userBuscado = usuarioService.obtenerUsuarioPorNombre(user);

                if (userBuscado.isPresent()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Acceso concedido");
                    alert.setHeaderText(null);
                    alert.setContentText("Bienvenido/a nuevamente " + userBuscado.get().getNombre());
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Acceso denegado");
                    alert.setHeaderText(null);
                    alert.setContentText("Usuario o contraseña incorrectos ");
                    alert.showAndWait();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Campos vacios");
                alert.setHeaderText(null);
                alert.setContentText("Porfavor ingresar usuario y contraseña");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void togglePasswordVisibility() {
        if (showPass.isSelected()) {
            passwordLogin.setPromptText(passwordLogin.getText());
            passwordLogin.setText("");
            passwordLogin.setStyle("-fx-prompt-text-fill: black;");
        } else {
            passwordLogin.setText(passwordLogin.getPromptText());
            passwordLogin.setPromptText("Password");
            passwordLogin.setStyle("");
        }
    }

//    @FXML
//    private void handleSubmit() {
//        String password = passwordLogin.getText();
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Password Submitted");
//        alert.setHeaderText(null);
//        alert.setContentText("Password: " + password);
//        alert.showAndWait();
//    }

    @FXML
    public void initialize() {
        String videoPath = getClass().getResource("/imagenes/video libro.mp4").toExternalForm();
        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        usuarioLogin.addEventFilter(KeyEvent.KEY_TYPED, this::handleKeyTyped);
//        passwordLogin.addEventFilter(KeyEvent.KEY_TYPED, this::handleKeyTyped);
    }


    private void handleKeyTyped(KeyEvent event) {
        if (event.getCharacter().equals(" ")) {
            event.consume();
        }
    }
}
