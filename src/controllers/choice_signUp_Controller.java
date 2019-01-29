package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.net.URL;
import java.security.Provider;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class choice_signUp_Controller implements Initializable {

     String server = "localhost";
     int port = 3306;
     String user = "admin";
     String password = "admin";
     String database = "project_gui";
     String jdbcurl;
     Connection con = null;
    @FXML
     AnchorPane switch_pane;
     @FXML
     Button provider,Back_Page,parent;



     @Override
     public void initialize(URL location, ResourceBundle resources) {
     }

    @FXML
    private void BackPageHandler(ActionEvent event)  throws Exception {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        switch_pane.getChildren().setAll(pane);
    }


    @FXML
    private void parentEventHandler(ActionEvent event)  throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../fxml/Sign_up_parent.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void providerEvnetHandler(ActionEvent event)  throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../fxml/Sign_up_Employee.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

 }