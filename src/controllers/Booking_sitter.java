package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Booking_sitter implements Initializable {
    @FXML
    ImageView home_choice,settings,help,start,home;
    @FXML
    SplitPane pane1;
    @FXML
    AnchorPane switchpane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
        @FXML
    private void home_choiceHandler(MouseEvent mouseEvent)throws Exception{
        pane1.setDividerPosition(0,0.2);
//        pane1.setDividerPosition(0,0.2);

    }
    @FXML
    private void home_choiceHandler2(MouseEvent mouseEvent)throws Exception{
        pane1.setDividerPosition(0,0.01);

    }
    @FXML
    public void startHandler(MouseEvent mouseEvent) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Baby_sitterBooking.fxml"));
        switchpane.getChildren().setAll(pane);

    }
    @FXML
    public void settingsHandler(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Settings.fxml"));
        switchpane.getChildren().setAll(pane);

    }
    @FXML
    public void helpHandler(javafx.scene.input.MouseEvent mouseEvent) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/Help&feedback.fxml"));
        switchpane.getChildren().setAll(pane);

    }
    @FXML
    public void loginpageHandler(MouseEvent mouseEvent) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        switchpane.getChildren().setAll(pane);

    }
}
