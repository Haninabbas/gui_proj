package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Booking_sitter implements Initializable {
    @FXML
    ImageView home_choice;
    @FXML
    SplitPane pane1;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
        @FXML
        private void home_choiceHandler(ActionEvent event)throws Exception{
        pane1.setDividerPosition(0,0.6);

        }

}
