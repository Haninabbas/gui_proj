package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class client_controller implements Initializable {
    @FXML
    SplitPane splitPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    public void onMouseEnter(MouseEvent mouseEvent) {
        splitPane.setDividerPosition(0,0.3);
    }

    public void onMouseEnter2(MouseEvent mouseEvent) {
        splitPane.setDividerPosition(0,0.01);
    }

}
