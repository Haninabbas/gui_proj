package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class sign_up_parent_Controller implements Initializable {
        String server = "localhost";
        int port = 3306;
        String user = "admin";
        String password = "admin";
        String database = "project_gui";
        String jdbcurl;
        Connection con = null;
//         private FileChooser fileChooser;
//
//        fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters().addAll(
//                new ExtensionFilter("Text Files", "*txt"),
//                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
//                new ExtensionFilter("Audio Files", "*wav", "*.mp3", "*.aac"),
//                new ExtensionFilter("All Files", "*.*")
//        );
    private Image image;
    @FXML
    Button Back_Page,Continue;
    @FXML
    AnchorPane switch_pane;
    @FXML
    Label no_fname,no_lname,no_email,no_pass,no_pass2,no_gender,no_num,no_location;
    @FXML
    TextField fname,Lname,Email,location,birthdate,num;
    @FXML
    PasswordField pass,confirm_pass;
    @FXML
    ComboBox<String> gender;
//    @FXML
//    ImageView image;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gender.getItems().addAll("Male", "Female");

}
    @FXML
    private void Back_Page(ActionEvent event)  throws Exception {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/choice_signUp.fxml"));
        switch_pane.getChildren().setAll(pane);
    }

//    BrowseAction.setOnAction(e ->
//
//    {
//        //Single File Selection
//        file = fileChooser.showOpenDialog(primaryStage);
//        if (file != null) {
//            textArea.setText(file.getAbsolutePath());
//            image = new Image(file.toURI().toString(), 100, 150, true, true);
//            ImageView = new ImageView(image);
//            ImageView.setFitWidth(100);
//            ImageView.setFitHeight(150);
//            ImageView.setPreserveRatio(true);
//
//            layout.setCenter(imageView);
//            BorderPane.setAlignment(imageView, Pos.TOP_LEFT);
//        }
//    }
    @FXML
    private void continueHandleEvent(ActionEvent event) {
        if (checkInfo())
            sign_up_parent();

    }

    private void sign_up_parent() {
        String FirstName = fname.getText();
        String LastName = Lname.getText();
        String email=Email.getText();
        String Password = pass.getText();
        String ConfirmPassword = confirm_pass.getText();
        String Location =location.getText();
        String phone = num.getText();
        String Gender = gender.getValue();
//        Image Image=image.getImage();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
            Statement stmt = con.createStatement();
            String test = "call addClient_info("+"'"+fname+"',"+"'"+Lname+"',"+"'"+Email+"',"+"'"+pass+"','"+num+"','"+gender+"','"+location+"','"+image+"')";
            ResultSet rs = stmt.executeQuery(test);
//            InputStream is=rs.getBinaryStream("image");
//            OutputStream os=new FileOutputStream(new File("photo.jpg"));
//            byte[] content =new byte[1024];
//            int size=0;
//            while ((size=is.read(content))!=-1){
//                os.write(content,0,size);
//            }
//            os.close();
//            is.close();
//            image=new  Image("file:photo.jpg",100,150,true);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private boolean checkInfo() {
        boolean flag = false;
        if (fname.getText().isEmpty()) {
            no_fname.setText("Please enter your FirstName");
            no_fname.setTextFill(javafx.scene.paint.Color.web("blue"));
            flag = false;
        } else
            no_fname.setText("");
        if (Lname.getText().isEmpty()) {
            no_lname.setText("Please enter your LastName");
            no_lname.setTextFill(javafx.scene.paint.Color.web("blue"));
            flag = false;
        } else
            no_lname.setText("");
        if (Email.getText().isEmpty()) {
            no_email.setText("Please enter your Email");
            no_email.setTextFill(javafx.scene.paint.Color.web("blue"));
            flag = false;
        } else
            no_email.setText("");
        if (pass.getText().isEmpty()) {
            no_pass.setText("Please enter your password");
            no_pass.setTextFill(javafx.scene.paint.Color.web("blue"));
            flag = false;
        }
        if (confirm_pass.getText().isEmpty() && !(confirm_pass.getText().equals(pass.getText()))) {
            no_pass2.setText("Please reconfirm your password");
            no_pass2.setTextFill(javafx.scene.paint.Color.web("blue"));
            flag = false;
        }
        if (num.getText().isEmpty()) {
            no_num.setText("Please enter your phonenum");
            no_num.setTextFill(javafx.scene.paint.Color.web("blue"));
            flag = false;
        } else
            no_num.setText("");
        if (gender.getValue() == null) {
            no_gender.setText("Please enter your gender");
            no_gender.setTextFill(javafx.scene.paint.Color.web("blue"));
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
        if (gender.getValue() != null  && !fname.getText().isEmpty() && !Lname.getText().isEmpty() && !Email.getText().isEmpty() && !num.getText().isEmpty() && !pass.getText().isEmpty()&&!confirm_pass.getText().isEmpty()
                &&!location.getText().isEmpty())
            flag = true;
        return flag;
    }


}
