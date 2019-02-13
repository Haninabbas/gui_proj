package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class Baby_sitterBooking implements Initializable {
@FXML
    ImageView start;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    private void startHandler(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../fxml/Baby_sitterBooking.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
