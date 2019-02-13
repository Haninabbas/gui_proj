package controllers;

import gui_classes.Baby_sitter;
import gui_classes.Booking;
import gui_classes.Client;
import gui_classes.Payment;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class Booking_sitter implements Initializable {
    Payment payment;
    Booking booking;
    Client client;
    Baby_sitter baby_sitter;
    @FXML
    ImageView home_choice;
    @FXML
    SplitPane pane1;
    @FXML
    DatePicker datePicker;
    Date date = new Date(datePicker.getValue().getYear());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        booking.addObserver(baby_sitter);


    }
    @FXML
    private void home_choiceHandler(ActionEvent event)throws Exception{
        pane1.setDividerPosition(0,0.6);

    }

    public void submit(ActionEvent event) {
        payment = new Payment(1,0);
        booking = new Booking(1,date,payment);
    }
}
