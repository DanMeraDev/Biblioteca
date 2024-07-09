package com.biblioteca.Biblioteca_virtual.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterControlador {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private TextField registerNombre, registerCorreo, registerApellido, registerUsuario, registerCelular, registerDNI;

    @FXML
    private PasswordField registerPass;

    @FXML
    private Button registerBtn;

    @FXML
    private void registrarUsuario(ActionEvent event) {

    }

    @FXML
    private void cargarLogin(ActionEvent event) {
        MainControlador.loadStage("/templates/login.fxml", event);
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
}
