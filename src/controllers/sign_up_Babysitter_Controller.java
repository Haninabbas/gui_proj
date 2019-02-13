package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.sql.*;
import javafx.scene.control.ComboBox;
import java.util.ResourceBundle;

public class sign_up_Babysitter_Controller implements Initializable {
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
    VBox main;
    @FXML
    Label no_fname,no_lname,no_email,no_pass,no_pass2,no_gender,no_birthdate,no_num,no_location,no_service,no_image;
    @FXML
    Button Continue,Back_Page;
    @FXML
    TextField fname,Lname,Email,location,birthdate,num;
    @FXML
    PasswordField pass,confirm_pass;
    @FXML
    ComboBox<String> gender,service;
    @FXML
    ImageView image,imageback;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gender.getItems().addAll("Male", "Female");
        service.getItems().addAll("BabySitter", "PrivateTutor");
    }

    @FXML
    private void Back_Page(ActionEvent event)  throws Exception {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/choice_signUp.fxml"));
        switch_pane.getChildren().setAll(pane);
    }

    @FXML
    private void continueHandleEvent(ActionEvent event) {
        if (checkInfo())
            sign_up_Employee();

    }

    private void sign_up_Employee() {
        String FirstName = fname.getText();
        String LastName = Lname.getText();
        String email=Email.getText();
        String Password = pass.getText();
        String ConfirmPassword = confirm_pass.getText();
        String Location =location.getText();
        String phone = num.getText();
        String date = birthdate.getText();
        String Gender = gender.getValue();
        String Service=service.getValue();
        String getservice_id="select Service_id from Services where Service_name='"+service.getValue()+"'";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
            Statement stmt = con.createStatement();
            ResultSet rs2 = stmt.executeQuery(getservice_id);
            while (rs2.next()){

            Service=rs2.getString(1);
            rs2.next();}
            String test = "call addEmployee_info("+"'"+fname+"',"+"'"+Lname+"',"+"'"+Email+"',"+"'"+pass+"','"+num+"','"+gender+"','"+birthdate+"','"+location+"',"+service+"','null')";
            ResultSet rs = stmt.executeQuery(test);

         }catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error in Database:execQuery" +e.getLocalizedMessage());
        }
    }



    private boolean checkInfo() {
        boolean flag = false;
        if (fname.getText().isEmpty()) {
            no_fname.setText("Please enter your FirstName");
            no_fname.setTextFill(Color.web("blue"));
            flag = false;
        }else
            no_fname.setText("");
        if (Lname.getText().isEmpty()) {
            no_lname.setText("Please enter your LastName");
            no_lname.setTextFill(Color.web("blue"));
            flag = false;
        }else
            no_lname.setText("");
        if (Email.getText().isEmpty()) {
            no_email.setText("Please enter your Email");
            no_email.setTextFill(Color.web("blue"));
            flag = false;
        }else
            no_email.setText("");
        if (pass.getText().isEmpty()) {
            no_pass.setText("Please enter your password");
            no_pass.setTextFill(Color.web("blue"));
            flag = false;
        }
        if (confirm_pass.getText().isEmpty()&&!(confirm_pass.getText().equals(pass.getText()))){
            no_pass2.setText("Please reconfirm your password");
            no_pass2.setTextFill(Color.web("blue"));
            flag = false;
        }
        if (num.getText().isEmpty()) {
            no_num.setText("Please enter your phonenum");
            no_num.setTextFill(Color.web("blue"));
            flag = false;
        } else
            no_num .setText("");
        if (birthdate.getText().isEmpty()) {
            no_birthdate.setText("Please enter date");
            no_birthdate.setTextFill(Color.web("blue"));
            flag = false;
        } else
            no_birthdate.setText("");
        if (gender.getValue() == null) {
            no_gender.setText("Please select your gender");
            no_gender.setTextFill(Color.web("blue"));
            flag = false;
        } else
            no_gender.setText("");
        if(location.getText().isEmpty()) {
            no_location.setText("please enter your location");
            no_location.setTextFill(Color.web("blue"));
            flag = false;
        }
        else
            no_location.setText("");
        if(service.getValue()==null) {
            no_service.setText("please select a service type");
            no_service.setTextFill(Color.web("blue"));
            flag = false;
        }
        else
            no_service.setText("");
        if (gender.getValue() != null &&service.getValue()!=null && !fname.getText().isEmpty() && !Lname.getText().isEmpty() && !Email.getText().isEmpty() && !num.getText().isEmpty() && !pass.getText().isEmpty()&&!confirm_pass.getText().isEmpty()
        &&!location.getText().isEmpty()&& !birthdate.getText().isEmpty())
            flag = true;
        return flag;
    }

}


