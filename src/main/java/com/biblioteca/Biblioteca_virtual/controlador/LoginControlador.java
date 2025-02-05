package com.biblioteca.Biblioteca_virtual.controlador;

import com.biblioteca.Biblioteca_virtual.modelos.Administrador;
import com.biblioteca.Biblioteca_virtual.modelos.Persona;
import com.biblioteca.Biblioteca_virtual.modelos.Usuario;
import com.biblioteca.Biblioteca_virtual.servicios.AdministradorService;
import com.biblioteca.Biblioteca_virtual.servicios.UsuarioService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class LoginControlador {

    private double xOffset = 0;
    private double yOffset = 0;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AdministradorService administradorService;

    @FXML
    private TextField usuarioLogin, passTextLogin;

    @FXML
    private PasswordField passwordLogin;

    @FXML
    private CheckBox showPass;

    @FXML
    private Button loginButton;

    @FXML
    private MediaView mediaView;

    @FXML
    private Hyperlink registroLink;



    @FXML
    private void cargarRegister(ActionEvent event) {
        MainControlador.loadStage("/templates/register.fxml", event);
    }


    @FXML
    private void accionIngresar(ActionEvent event) {
        if (!usuarioLogin.getText().isEmpty() && !passwordLogin.getText().isEmpty()) {
            String user = usuarioLogin.getText();

            Optional<Usuario> userBuscado;
            Optional<Administrador> adminBuscado;

            if (administradorService.obtenerAdministradorPorUsername(user).isPresent()) {
                adminBuscado = administradorService.obtenerAdministradorPorUsername(user);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Acceso como ADMINISTRADOR concedido");
                alert.setHeaderText(null);
                alert.setContentText("Bienvenido/a nuevamente " + adminBuscado.get().getNombre());
                alert.showAndWait();
                MainControlador.loadStage("/templates/mainAdmin.fxml", event);

                // Cerrar la ventana de login
                closeLoginWindow(event);

            } else if (usuarioService.obtenerUsuarioPorUsername(user).isPresent()) {
                userBuscado = usuarioService.obtenerUsuarioPorUsername(user);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Acceso concedido");
                alert.setHeaderText(null);
                alert.setContentText("Bienvenido/a nuevamente " + userBuscado.get().getNombre());
                alert.showAndWait();
                MainControlador.loadStage("/templates/mainUser.fxml", event);

                // Cerrar la ventana de login
                closeLoginWindow(event);

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Acceso denegado");
                alert.setHeaderText(null);
                alert.setContentText("Usuario o contraseña incorrectos");
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

    private void closeLoginWindow(ActionEvent event) {
        if (event != null && event.getSource() instanceof Node) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }


    @FXML
    private void togglePasswordVisibility() {
        if (showPass.isSelected()) {
            passTextLogin.setVisible(true);
            passTextLogin.setManaged(true);
            passwordLogin.setVisible(false);
            passwordLogin.setManaged(false);
        } else {
            passTextLogin.setVisible(false);
            passTextLogin.setManaged(false);
            passwordLogin.setVisible(true);
            passwordLogin.setManaged(true);
        }
    }
    @FXML
    private void minimizarVentana(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void cerrarVentana(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onMousePressed(MouseEvent event) {
        Stage stage = (Stage) ((HBox) event.getSource()).getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
        ((HBox) event.getSource()).setCursor(Cursor.MOVE);
    }

    @FXML
    private void onMouseDragged(MouseEvent event) {
        Stage stage = (Stage) ((HBox) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }

    @FXML
    private void onMouseReleased(MouseEvent event) {
        ((HBox) event.getSource()).setCursor(Cursor.DEFAULT);
    }

    @FXML
    public void initialize() {
        String videoPath = getClass().getResource("/imagenes/video libro.mp4").toExternalForm();
        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        usuarioLogin.addEventFilter(KeyEvent.KEY_TYPED, this::handleKeyTyped);
        passwordLogin.addEventFilter(KeyEvent.KEY_TYPED, this::handleKeyTyped);
        passTextLogin.textProperty().bindBidirectional(passwordLogin.textProperty());
        usuarioLogin.setOnKeyPressed(this::handleKeyPressed);
        passwordLogin.setOnKeyPressed(this::handleKeyPressed);

    }

    private void handleKeyTyped(KeyEvent event) {
        if (event.getCharacter().equals(" ")) {
            event.consume();
        }
    }

    private void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            accionIngresar(null);
        }
    }

}
