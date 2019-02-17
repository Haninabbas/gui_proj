package controllers;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomePage implements Initializable {
    @FXML
    Shape circle1, circle2, circle3;
    @FXML
    Label label1, label2, label3, label4;
    @FXML
    Button bt1, bt2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        animation();
    }

    public void animation() {
        FadeTransition circle1anim = new FadeTransition(Duration.millis(1800), circle1);
        circle1anim.setFromValue(0.0);
        circle1anim.setToValue(1.0);

        FadeTransition circle2anim = new FadeTransition(Duration.millis(1800), circle2);
        circle2anim.setFromValue(0.0);
        circle2anim.setToValue(1.0);

        FadeTransition circle3anim = new FadeTransition(Duration.millis(1800), circle3);
        circle3anim.setFromValue(0.0);
        circle3anim.setToValue(1.0);

        FadeTransition label1anim = new FadeTransition(Duration.millis(1800), label1);
        label1anim.setFromValue(0.0);
        label1anim.setToValue(1.0);

        FadeTransition label2anim = new FadeTransition(Duration.millis(1800), label2);
        label2anim.setFromValue(0.0);
        label2anim.setToValue(1.0);

        FadeTransition label3anim = new FadeTransition(Duration.millis(1800), label3);
        label3anim.setFromValue(0.0);
        label3anim.setToValue(1.0);

        FadeTransition label4anim = new FadeTransition(Duration.millis(1800), label4);
        label4anim.setFromValue(0.0);
        label4anim.setToValue(1.0);

        FadeTransition bt1anim = new FadeTransition(Duration.millis(1800), bt1);
        bt1anim.setFromValue(0.0);
        bt1anim.setToValue(1.0);

        FadeTransition bt2anim = new FadeTransition(Duration.millis(1800), bt2);
        bt2anim.setFromValue(0.0);
        bt2anim.setToValue(1.0);

        TranslateTransition circle1trans = new TranslateTransition(Duration.millis(1200), circle1);
        circle1trans.setFromY(120);
        circle1trans.setToY(0);

        TranslateTransition circle2trans = new TranslateTransition(Duration.millis(1200), circle2);
        circle2trans.setFromY(140);
        circle2trans.setToY(0);

        TranslateTransition circle3trans = new TranslateTransition(Duration.millis(1200), circle3);
        circle3trans.setFromY(160);
        circle3trans.setToY(0);

        TranslateTransition label1trans = new TranslateTransition(Duration.millis(1200), label1);
        label1trans.setFromY(160);
        label1trans.setToY(0);

        TranslateTransition label2trans = new TranslateTransition(Duration.millis(1200), label2);
        label2trans.setFromY(100);
        label2trans.setToY(0);

        TranslateTransition bt1trans = new TranslateTransition(Duration.millis(1200), bt1);
        bt1trans.setFromY(100);
        bt1trans.setToY(0);

        TranslateTransition bt2trans = new TranslateTransition(Duration.millis(1200), bt2);
        bt2trans.setFromY(100);
        bt2trans.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(circle1anim, circle2anim, circle3anim, label2anim, label3anim, label4anim, bt1anim, bt2anim, circle1trans, circle2trans, circle3trans, label1trans, label2trans, bt1trans, bt2trans);
        parallelTransition.play();
    }

    @FXML
    private void backhomeHandler(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("fxml/Login.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void bookHandler(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("fxml/BookingSitter.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}