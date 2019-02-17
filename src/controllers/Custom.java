package controllers;

import gui_classes.CustomData;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import org.controlsfx.control.Rating;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Custom extends ListCell<CustomData> {
    CustomData customData;
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

//    public Custom(CustomData customData) {
////        this.customData = customData;
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
//                "../fxml/Custom.fxml"));
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
//
//        try {
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
//    }

    public void loadFXML(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Custom.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void updateItem(CustomData customData, boolean empty){
        super.updateItem(customData,empty);
        name.setText(customData.getName1());
        phone.setText(customData.getPhone1());
        address.setText(customData.getAddress1());
        age.setText(customData.getAge1());
        email.setText(customData.getEmail1());
        price_hour.setText(customData.getPrice_hour1());
        rating.setRating(customData.getRating1());
    }



    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }
}
