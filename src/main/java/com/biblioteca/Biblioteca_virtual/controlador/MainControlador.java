package com.biblioteca.Biblioteca_virtual.controlador;

import com.biblioteca.Biblioteca_virtual.presentacion.SistemaBibliotecaFX;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainControlador {

    public static void loadStage(String url, Event event) {
        try {
            if (event != null && event.getSource() instanceof Node) {
                ((Node) event.getSource()).getScene().getWindow().hide();
            }

            Parent root = FXMLLoader.load(Objects.requireNonNull(MainControlador.class.getResource(url)));
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.setResizable(false);
            newStage.initStyle(StageStyle.UNDECORATED);
            newStage.show();

            newStage.setOnCloseRequest(windowEvent -> Platform.exit());
        } catch (IOException e) {
            Logger.getLogger(SistemaBibliotecaFX.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
