package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene Main = new Scene(root);
        stage.setFullScreen(true);
        //Main.getStylesheets().addAll(this.getClass().getResource("Menu.css").toExternalForm());
        stage.setTitle("Game");
        stage.setScene(Main);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}