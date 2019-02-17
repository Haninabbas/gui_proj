package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Client implements Initializable {
    private  int ID;
    @FXML
    SplitPane splitPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(ID+"");
    }
    @FXML
    public void onMouseEnter(MouseEvent mouseEvent) {
        splitPane.setDividerPosition(0,0.3);
    }

    public void onMouseEnter2(MouseEvent mouseEvent) {
        splitPane.setDividerPosition(0,0.01);
    }

    void setID(int ID){
        this.ID = ID;
        System.out.println(ID+"");
    }
    public Client getController(){
        return this;
    }
    public void setData(){

    }
}
