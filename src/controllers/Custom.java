package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import org.controlsfx.control.Rating;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Custom implements Initializable {
    Connection con;
    public Label name;
    public Label phone;
    public Label address;
    public Label age;
    public Label email;
    public Label price_hour;
    public Rating rating;
    @FXML
    Circle circle;
    @FXML
    GridPane gridPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
            Statement stmt = con.createStatement();
        } catch(Exception e){
                e.printStackTrace();
        }
    }
}
