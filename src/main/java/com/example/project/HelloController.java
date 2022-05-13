package com.example.project;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    @FXML
    private Label Name;
    private Button Single;
    private Button Cooperate;
    private Button Study;
    private Stage stage;
    private Scene Main;
    private Parent root;
    private Label label;

    public void OnStudyButtonClick(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Study.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Main = new Scene(root);
        stage.setScene(Main);
        stage.setFullScreen(true);
        stage.show();
    }

    public void onSingleButtonClick(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Single.fxml"));
        stage = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        Main = new Scene(root);
        stage.setScene(Main);
        stage.setFullScreen(true);
        stage.show();}

    public void OnCooperateButtonClick(MouseEvent mouseEvent) {Name.setText("2");}
}