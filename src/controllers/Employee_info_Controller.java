//package controllers;
//
//import gui_classes.Baby_sitter;
//import javafx.beans.property.ReadOnlyStringWrapper;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.image.Image;
//import javafx.scene.layout.AnchorPane;
//
//import java.net.URL;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//public class Employee_info_Controller implements Initializable {
//
//    String server = "localhost";
//    int port = 3306;
//    String user = "admin";
//    String password = "admin";
//    String database = "project_gui";
//    String jdbcurl;
//    Connection con = null;
//    private PreparedStatement pst=null;
//    @FXML
//    TextField Employee_fname_field, Employee_lname_field;
//    @FXML
//    AnchorPane switch_pane, container;
//    @FXML
//    TextField search;
//    @FXML
//    TableView<Baby_sitter> table;
//    @FXML
//    TableColumn<Baby_sitter, String> employee_id, employee_fname, employee_lname, employee_pass, employee_email, employee_phonenum, employee_location, employee_gender, employee_birthdate, employee_service;
//    @FXML
//    TableColumn<Baby_sitter, Image> employee_image;
//    @FXML
//    Label not_found, label;
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        int eid,service;
//        String fname, lname, pass, email,
//                phonenum, Elocation, gender, birthdate ;
//        ArrayList<String> Service= new ArrayList<>();
//        ArrayList<Integer> Eid = new ArrayList<>();
//        ArrayList<String> Ename = new ArrayList<>();
//        ArrayList<String> Elname= new ArrayList<>();
//        ArrayList<String> Gender=new ArrayList<>();
//        ArrayList<String> loc=new ArrayList<>();
//        ArrayList<String > birth = new ArrayList<>();
//        ArrayList<String> num = new ArrayList<>();
//        ArrayList<String> password = new ArrayList<>();
//        ArrayList<String> Email = new ArrayList<>();
//        ArrayList<Integer> service_id = new ArrayList<>();
//        ArrayList<byte[]>  Image= new ArrayList<>();
//
//        employee_id.setCellValueFactory(data -> {
//            Baby_sitter value = data.getValue();
//            String string = "" + value.getId();
//            return new ReadOnlyStringWrapper(string);
//        });
//        employee_fname.setCellValueFactory(data -> {
//            Baby_sitter value = data.getValue();
//            String string = value.getfName();
//            return new ReadOnlyStringWrapper(string);
//        });
//        employee_lname.setCellValueFactory(data -> {
//            Baby_sitter value = data.getValue();
//            return new ReadOnlyStringWrapper(value.getlName());
//        });
//        employee_email.setCellValueFactory(data -> {
//            Baby_sitter value = data.getValue();
//            return new ReadOnlyStringWrapper(((Baby_sitter) value).getEmail());
//        });
//        employee_pass.setCellValueFactory(data -> {
//            Baby_sitter value = data.getValue();
//            return new ReadOnlyStringWrapper(((Baby_sitter) value).getPassword());
//        });
//
//        employee_phonenum.setCellValueFactory(data -> {
//            Baby_sitter value = data.getValue();
//            return new ReadOnlyStringWrapper(((Baby_sitter) value).getPhonenum());
//        });
//        employee_gender.setCellValueFactory(data -> {
//            Baby_sitter value = data.getValue();
//            return new ReadOnlyStringWrapper(((Baby_sitter) value).getGender());
//        });
//        employee_birthdate.setCellValueFactory(data -> {
//            Baby_sitter value = data.getValue();
//            return new ReadOnlyStringWrapper(((Baby_sitter) value).getBirthdate());
//        });
//        employee_location.setCellValueFactory(data -> {
//            Baby_sitter value = data.getValue();
//            return new ReadOnlyStringWrapper(((Baby_sitter) value).getLocation());
//        });
//        employee_service.setCellValueFactory(data -> {
//            Baby_sitter value = data.getValue();
//            String string = "" + value.getService();
//            return new ReadOnlyStringWrapper(string);
//        });
//        employee_image.setCellValueFactory(new PropertyValueFactory<Baby_sitter,Image>("Image"));
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            String get_data = "select * from Employee_info";
//            ResultSet rs = stmt.executeQuery(get_data);
//            ResultSet rs2;
//            while (rs.next()) {
//                Eid.add(  rs.getInt(1));
//                Ename.add(rs.getString(2));
//                Elname.add( rs.getString(3));
//                Email.add( rs.getString(4));
//                password.add( rs.getString(5));
//                num.add(rs.getString(6));
//                Gender.add( rs.getString(7));
//                birth.add(rs.getString(8));
//                loc.add(rs.getString(9));
//                service_id.add( rs.getInt(10));
//
//                try {
//                    Blob imageBlob = rs.getBlob(11);
//                    if(imageBlob!=null)
//                        Image.add(imageBlob.getBytes(1, (int) imageBlob.length()));
//                    else
//                        Image.add(null);
//                } catch(Exception e){
//                    e.printStackTrace();
//                }
//
//            }
//            for (int i = 0; i < service_id.size(); i++) {
//                String getservice_name = "select Service_name from Services where Service_id=" + service_id.get(i);
//                rs2 = stmt.executeQuery(getservice_name);
//                rs2.next();
//                Service.add(rs2.getString(1));
//                table.getItems().add(new Baby_sitter(Eid.get(i), Ename.get(i), Elname.get(i), Email.get(i), password.get(i), num.get(i), Gender.get(i), birth.get(i), loc.get(i), Service.get(i),Image.get(i)));
//            }
//            } catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//
//
//
//    @FXML
//    private void updatefNameHandler(TableColumn.CellEditEvent event) {
//        Baby_sitter babysitter = table.getSelectionModel().getSelectedItem();
//        String edit = "call updateEFname('" + babysitter.getId() + "','" + event.getNewValue() + "')";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            stmt.executeQuery(edit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void updatelNameHandler(TableColumn.CellEditEvent event) {
//        Baby_sitter babysitter = table.getSelectionModel().getSelectedItem();
//        String edit = "call updateELname('" + babysitter.getId() + "','" + event.getNewValue() + "')";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            stmt.executeQuery(edit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void updateemailHandler(TableColumn.CellEditEvent event) {
//        Baby_sitter babysitter = table.getSelectionModel().getSelectedItem();
//        String edit = "call update_EEmail('" + babysitter.getId() + "','" + event.getNewValue() + "')";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            stmt.executeQuery(edit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void updatepassHandler(TableColumn.CellEditEvent event) {
//        Baby_sitter babysitter = table.getSelectionModel().getSelectedItem();
//        String edit = "call update_Epass('" + babysitter.getId() + "','" + event.getNewValue() + "')";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            stmt.executeQuery(edit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void updategenderHandler(TableColumn.CellEditEvent event) {
//        Baby_sitter babysitter = table.getSelectionModel().getSelectedItem();
//        String edit = "call update_Egender('" + babysitter.getId() + "','" + event.getNewValue() + "')";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            stmt.executeQuery(edit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void updatelocationHandler(TableColumn.CellEditEvent event) {
//        Baby_sitter babysitter = table.getSelectionModel().getSelectedItem();
//        String edit = "call update_Elocation('" + babysitter.getId() + "','" + event.getNewValue() + "')";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            stmt.executeQuery(edit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void updatephonenumHandler(TableColumn.CellEditEvent event) {
//        Baby_sitter babysitter = table.getSelectionModel().getSelectedItem();
//        String edit = "call updatephonenum('" + babysitter.getId() + "','" + event.getNewValue() + "')";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            stmt.executeQuery(edit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void updatebirthdateHandler(TableColumn.CellEditEvent event) {
//        Baby_sitter babysitter = table.getSelectionModel().getSelectedItem();
//        String edit = "call update_birthdate('" + babysitter.getId() + "','" + event.getNewValue() + "')";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            stmt.executeQuery(edit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void updatesServiceTypeHandler(TableColumn.CellEditEvent event) {
//        Baby_sitter babysitter = table.getSelectionModel().getSelectedItem();
//        String edit = "call update_service('" + babysitter.getId() + "','" + event.getNewValue() + "')";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            stmt.executeQuery(edit);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void editEmployeeInfo(ActionEvent event) {
//        table.setEditable(true);
//        employee_id.setCellFactory(TextFieldTableCell.forTableColumn());
//        employee_fname.setCellFactory(TextFieldTableCell.forTableColumn());
//        employee_lname.setCellFactory(TextFieldTableCell.forTableColumn());
//        employee_email.setCellFactory(TextFieldTableCell.forTableColumn());
//        employee_pass.setCellFactory(TextFieldTableCell.forTableColumn());
//        employee_phonenum.setCellFactory(TextFieldTableCell.forTableColumn());
//        employee_gender.setCellFactory(TextFieldTableCell.forTableColumn());
//        employee_birthdate.setCellFactory(TextFieldTableCell.forTableColumn());
//        employee_location.setCellFactory(TextFieldTableCell.forTableColumn());
//        employee_service.setCellFactory(TextFieldTableCell.forTableColumn());
//    }
//
//
//
//    @FXML
//    private void deletEmployee(ActionEvent event) {
//        int id = table.getSelectionModel().getSelectedItem().getId();
//        String delete_Client = "call delete_employee('" + id + "')";
//        table.getItems().remove(table.getSelectionModel().getSelectedItem());
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gui", "admin", "admin" + "");
//            Statement stmt = con.createStatement();
//            stmt.executeQuery(delete_Client);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    private void searchEmployee() {
//        if (search.getText().equals("")) {
//            table.getItems().clear();
//            try {
//                pst = con.prepareStatement("select *from Employee_info");
//                ResultSet rs = pst.executeQuery();
//                while (rs.next()) {
//                    table.getItems().add(new Baby_sitter(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getBytes(11)));
//                }
//            } catch (SQLException e1) {
//
//                Logger.getLogger(Employee_info_Controller.class.getName()).log(Level.SEVERE ,null,pst);
//            }
//        }
//        else {
//            table.getItems().clear();
//            String sql = "select * from Employee_info where Employee_FirstName like '"  + search.getText() + "%'";
//            try {
//                pst = con.prepareStatement(sql);
//                ResultSet rs = pst.executeQuery();
//                while (rs.next()) {
//
//                    int eid = rs.getInt(1);
//                    String fname = rs.getString(2);
//                    String lname = rs.getString(3);
//                    String email = rs.getString(4);
//                    String phonenum = rs.getString(5);
//                    String pass = rs.getString(6);
//                    String gender = rs.getString(7);
//                    String birthdate = rs.getString(8);
//                    String elocation = rs.getString(9);
//                    String service = rs.getString(10);
//                    Blob imageBlob = rs.getBlob(11);
//                    byte[] image=imageBlob.getBytes(1, (int) imageBlob.length());
//                    table.getItems().add(new Baby_sitter(eid, fname, lname, email, pass, phonenum, gender, birthdate, elocation, service,image));
//                }
//                } catch(SQLException e1){
//                    Logger.getLogger(Employee_info_Controller.class.getName()).log(Level.SEVERE, null, pst);
//                }
//
//            }
//    }
//}