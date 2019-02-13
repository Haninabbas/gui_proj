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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Booking_sitter implements Initializable {
    @FXML
    ImageView home_choice;
    @FXML
    SplitPane pane1;
    @FXML
    AnchorPane switchpane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
        @FXML
        private void home_choiceHandler(ActionEvent event)throws Exception{
        pane1.setDividerPosition(0,0.6);

        }

    public void startHandler(MouseEvent mouseEvent) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Baby_sitterBooking.fxml"));
        switchpane.getChildren().setAll(pane);

    }
}
