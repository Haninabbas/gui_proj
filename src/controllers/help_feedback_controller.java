package controllers;

import gui_classes.Baby_sitter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import java.sql.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class help_feedback_controller implements Initializable {
    @FXML
    Button change,delete,add,feedback;
    Connection con = null;
    @FXML
    AnchorPane switchpane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public void changepass_handler(ActionEvent event)throws Exception{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/change_pass.fxml"));
        switchpane.getChildren().setAll(pane);

    }


    }

