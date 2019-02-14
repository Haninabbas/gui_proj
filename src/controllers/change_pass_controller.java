package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class change_pass_controller implements Initializable {
    @FXML
    Button bt1;
    @FXML
    Label no_username,no_pass1,no_pass2,no_pass3;
    @FXML
    TextField txt1;
    @FXML
    PasswordField pass1,pass2,pass3;
    @FXML
    ImageView visible1,visible2,visible3;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private boolean checkInfo () {
        boolean flag = false;
        if (txt1.getText().isEmpty()) {
            no_username.setText("Please enter your username");
            no_username.setTextFill(Color.web("#00CED1"));
            flag = false;
        }
        if (pass1.getText().isEmpty()) {
            no_pass1.setText("Please enter your Pass");
            no_pass1.setTextFill(Color.web("#00CED1"));
            flag = false;
        }
        if (pass2.getText().isEmpty()) {
            no_pass2.setText("Please reenter your new Pass");
            no_pass2.setTextFill(Color.web("#00CED1"));
            flag = false;
        }
        if (pass3.getText().isEmpty()) {
            no_pass3.setText("Please confirm your Pass");
            no_pass3.setTextFill(Color.web("#00CED1"));
            flag = false;
        }
        if (!txt1.getText().isEmpty() && !pass1.getText().isEmpty() &&!pass2.getText().isEmpty() &&!pass3.getText().isEmpty())
            flag = true;
        return flag;
    }
    @FXML
    public void visibleHandler1(javafx.scene.input.MouseEvent mouseEvent) throws Exception
        {
            pass1.setText(pass1.getText());
        }
        @FXML
        public void visibleHandler2(javafx.scene.input.MouseEvent mouseEvent) throws Exception{

                pass2.setText(pass2.getText());
            }

    @FXML
    public void visibleHandler3(javafx.scene.input.MouseEvent mouseEvent) throws Exception {
        {
            pass3.setText(pass3.getText());
        }
    }


}
