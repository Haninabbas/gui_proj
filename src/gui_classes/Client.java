package gui_classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Client{

    private SimpleIntegerProperty id;
    private SimpleStringProperty fname;
    private SimpleStringProperty lname;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    private SimpleStringProperty birthdate;
    private SimpleStringProperty phonenum;
    private SimpleStringProperty Clocation;
    private SimpleStringProperty gender;
    private byte[] image;


    public Client(int id,String fname,String lname,String email,String password,String phonenum,String gender,String Clocation,byte[] image) {
        this.id = new SimpleIntegerProperty(id);
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.email  = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.phonenum = new SimpleStringProperty(phonenum);
        this.Clocation = new SimpleStringProperty(Clocation);
        this.gender = new SimpleStringProperty(gender);
        this.image= image;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getfName() {
        return fname.get();
    }
    public SimpleStringProperty fnameProperty() {
        return fname;
    }
    public String getlName() {
        return lname.get();
    }

    public SimpleStringProperty lnameProperty() {
        return lname;
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailproperty() {
        return email;
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public String getBirthdate() {
        return birthdate.get();
    }

    public SimpleStringProperty birthdateProperty() {
        return birthdate;
    }
    public String getPhonenum(){
        return phonenum.get();
    }
    public SimpleStringProperty phonenumProperty(){
        return phonenum;
    }
    public String getLocation(){
        return Clocation.get();
    }

    public SimpleStringProperty locationProperty(){
        return Clocation;
    }
    public String getGender(){
        return gender.get();
    }
    public SimpleStringProperty genderProperty(){
        return gender;
    }
    public byte getimage(){
        return  getimage();
    }
    public void setId(int id) {
        this.id.set(id);
    }

    public void setfName(String name) {
        this.fname.set(name);
    }
    public void setLname(String name) {
        this.lname.set(name);
    }

    public void setEmail(String amout) {
        this.email.set(amout);
    }

    public void setPassword(String auth) {
        this.password.set(auth);
    }

    public void setPhonenum(String cat) {
        this.phonenum.set(cat);
    }
    public void setLocation(String cat) {
        this.Clocation.set(cat);
    }
    public void setGender(String cat) {
        this.gender.set(cat);
    }
    public void setImage(byte image){
        image=image;
    }

}


