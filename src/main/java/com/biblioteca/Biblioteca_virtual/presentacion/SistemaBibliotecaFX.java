package com.biblioteca.Biblioteca_virtual.presentacion;

import com.biblioteca.Biblioteca_virtual.BibliotecaVirtualApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;



public class SistemaBibliotecaFX extends Application {

    private ConfigurableApplicationContext applicationContext;
//    public static void main(String[] args) {
//        launch(args);
//    }

    @Override
    public void init() {
        this.applicationContext = new SpringApplicationBuilder(BibliotecaVirtualApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception{

        FXMLLoader loader = new FXMLLoader(BibliotecaVirtualApplication.class.getResource("/templates/login.fxml"));
        loader.setControllerFactory(applicationContext::getBean);


        Scene escena = new Scene(loader.load());
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(escena);
//        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }
}
