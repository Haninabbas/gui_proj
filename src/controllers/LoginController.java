package controllers;

import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private static int ID;

    String server = "localhost";
    int port = 3306;
    String user = "admin";
    String Password = "admin";
    String database = "project_gui";
    String jdbcurl;
    Connection con = null;

    @FXML
    ImageView imageView,visible;
    @FXML
    TextField username, password;
    @FXML
    Button login_button,signup_button;
    @FXML
    Label no_email,no_pass,showresult;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        animation();
    }

    public void animation() {
        FadeTransition userfadeanimation = new FadeTransition(Duration.millis(1800), username);
        userfadeanimation.setFromValue(0.0);
        userfadeanimation.setToValue(1.0);

        FadeTransition buttonfadetranslation = new FadeTransition(Duration.millis(1800), login_button);
        buttonfadetranslation.setFromValue(0.0);
        buttonfadetranslation.setToValue(1.0);

        FadeTransition button2fadetranslation = new FadeTransition(Duration.millis(1800), signup_button);
        button2fadetranslation.setFromValue(0.0);
        button2fadetranslation.setToValue(1.0);

        FadeTransition passfadeanimation = new FadeTransition(Duration.millis(1800), password);
        passfadeanimation.setFromValue(0.0);
        passfadeanimation.setToValue(1.0);

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1800), imageView);
        fadeTransition.setFromValue(0.0);
        fadeTransition.setToValue(1.0);

        TranslateTransition usertranslateTransition = new TranslateTransition(Duration.millis(1200), username);
        usertranslateTransition.setFromY(120);
        usertranslateTransition.setToY(0);

        TranslateTransition passtranslateTransition = new TranslateTransition(Duration.millis(1200), password);
        passtranslateTransition.setFromY(140);
        passtranslateTransition.setToY(0);

        TranslateTransition buttontranslateTransition = new TranslateTransition(Duration.millis(1200), login_button);
        buttontranslateTransition.setFromY(160);
        buttontranslateTransition.setToY(0);

        TranslateTransition button2translateTransition = new TranslateTransition(Duration.millis(1200), signup_button);
        button2translateTransition.setFromY(160);
        button2translateTransition.setToY(0);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1200), imageView);
        translateTransition.setFromY(100);
        translateTransition.setToY(0);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(button2fadetranslation,button2translateTransition,buttontranslateTransition, buttonfadetranslation, fadeTransition, translateTransition, passfadeanimation, passtranslateTransition, userfadeanimation, usertranslateTransition);
        parallelTransition.play();
    }

    @FXML
    public void loginHandler(ActionEvent event) throws IOException {

        PauseTransition pauseTransition = new PauseTransition(Duration.millis(100));
        login_button.setTextFill(Color.web("#2560c6"));

        pauseTransition.setOnFinished(e -> {
            login_button.setTextFill(Color.web("#00CED1"));


        });
        pauseTransition.play();

            if (checkInfo() && loginAsClient()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ClientPage.fxml"));
                Parent parent = (Parent) loader.load();
                Scene scene = new Scene(parent);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } else if (checkInfo() && loginAsBabysitter()) {
                Parent parent = FXMLLoader.load(getClass().getResource("../fxml/BabysitterPage.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            if (checkInfo() && loginAsAdmin()) {
                Parent parent = FXMLLoader.load(getClass().getResource("../fxml/AdminPage.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }

        }


    @FXML
    private void sign_upEventHandler(ActionEvent event) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../fxml/ChoiceSignUp.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    private boolean checkInfo () {
        boolean flag = false;
        if (username.getText().isEmpty()) {
            no_email.setText("Please enter your email");
            no_email.setTextFill(javafx.scene.paint.Color.web("#00CED1"));
            flag = false;
        }
        if (password.getText().isEmpty()) {
            no_pass.setText("Please enter your Pass");
            no_pass.setTextFill(Color.web("#00CED1"));
            flag = false;
        }
        if (!username.getText().isEmpty() && !password.getText().isEmpty())
            flag = true;
        return flag;
    }
    private boolean loginAsAdmin(){
        String UserName = username.getText();
        String Password = password .getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
            Statement stmt = con.createStatement(),stmt2 = con.createStatement();
            String data = "select username,password  from Person where username='" + UserName + "'and password='" + Password + "'" ;
            ResultSet rs2 = stmt.executeQuery(data),rs3;
            if (rs2.next()) {
                System.out.println("found admin");
                rs3 = stmt2.executeQuery("select Person_username from admin where Person_username='"+UserName+"'");
                if(rs3.next())
                    return true;
                else{
                    showresult.setText("failed to login");
                    return false;
                }
            } else {
                showresult.setText("failed to login");
                return false;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

}
    private boolean loginAsClient () {
        String UserName = username.getText();
        String Password = password  .getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
            Statement stmt = con.createStatement(),stmt2 = con.createStatement();
            String data = "select * from Person where username='"+UserName+"'and password='"+Password+"';";
            ResultSet rs2 = stmt.executeQuery(data),rs3;
            if (rs2.next()) {
                System.out.println("found client");
                rs3 = stmt2.executeQuery("select * from Client where Person_username='"+UserName+"';");
                if(rs3.next()){
                    ID = rs3.getInt(1);
                    return true;
                }
                else{
                    showresult.setText("failed to login");
                    return false;
                }
            } else {
                showresult.setText("failed to login");
                return false;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }

    private boolean loginAsBabysitter () {
            String UserName = username.getText();
            String Password = password  .getText();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
                Statement stmt = con.createStatement(),stmt2 = con.createStatement();
                String data = "select username,password  from Person where username='" + UserName + "'and password='" + Password + "'";
                ResultSet rs2 = stmt.executeQuery(data),rs3;
                if (rs2.next()) {

                    rs3 = stmt2.executeQuery("select Person_username from babysitter where Person_username='"+UserName+"'");
                    if(rs3.next())
                        return true;
                    else{
                        System.out.println("found babysitter");
                        showresult.setText("failed to login");
                        return false;
                    }
                } else {
                    showresult.setText("failed to login");
                    return false;
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }
        public void EnterEvent(KeyEvent keyEvent)throws  IOException{
            if (keyEvent.getCode() == KeyCode.ENTER) {
                PauseTransition pauseTransition = new PauseTransition(Duration.millis(100));
                login_button.setTextFill(Color.web("#2560c6"));

                pauseTransition.setOnFinished(e -> {
                    login_button.setTextFill(Color.web("#00CED1"));


                });
                pauseTransition.play();

                if (checkInfo() && loginAsClient()) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/ClientPage.fxml"));
                    Parent parent = (Parent) loader.load();
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node) keyEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                } else if (checkInfo() && loginAsBabysitter()) {
                    Parent parent = FXMLLoader.load(getClass().getResource("../fxml/BabysitterPage.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node) keyEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }
                if (checkInfo() && loginAsAdmin()) {
                    Parent parent = FXMLLoader.load(getClass().getResource("../fxml/AdminPage.fxml"));
                    Scene scene = new Scene(parent);
                    Stage stage = (Stage) ((Node) keyEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();
                }

            }
            }
        }





