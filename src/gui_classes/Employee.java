package gui_classes;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Employee {


        private SimpleIntegerProperty id;
        private SimpleStringProperty fname;
        private SimpleStringProperty lname;
        private SimpleStringProperty email;
        private SimpleStringProperty password;
        private SimpleStringProperty birthdate;
        private SimpleStringProperty phonenum;
        private SimpleStringProperty Clocation;
        private SimpleStringProperty gender;
         private SimpleStringProperty service;
          private byte[] image;

        public Employee(int id,String fname,String lname,String email,String password ,String phonenum,String gender,String birthdate,String Clocation,String service,byte [] image) {
            this.id = new SimpleIntegerProperty(id);
            this.fname = new SimpleStringProperty(fname);
            this.lname = new SimpleStringProperty(lname);
            this.email  = new SimpleStringProperty(email);
            this.password = new SimpleStringProperty(password);
            this.birthdate=new SimpleStringProperty(birthdate);
            this.phonenum = new SimpleStringProperty(phonenum);
            this.Clocation = new SimpleStringProperty(Clocation);
            this.gender = new SimpleStringProperty(gender);
            this.service=new SimpleStringProperty(service);
            this.image=image;
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

        public String  getService(){
        return service.get();
    }
        public SimpleStringProperty serviceProperty(){
        return service;
    }

        public void setId(int id) {
            this.id.set(id);
        }
    public byte getimage(){
        return  getimage();
    }

        public void setfName(String name) {
            this.fname.set(name);
        }
        public void setLname(String lname) {
            this.lname.set(lname);
        }

        public void setEmail(String email) {
            this.email.set(email);
        }

        public void setPassword(String password) {
            this.password.set(password);
        }
        public void setBirthdate(String birthdate) {
            this.birthdate.set(birthdate);
        }

        public void setPhonenum(String phonenum) {
            this.phonenum.set(phonenum);
        }
        public void setLocation(String location) {
            this.Clocation.set(location);
        }
        public void setGender(String gender) {
            this.gender.set(gender);
        }
    public void setService(String  service) {
        this.service.set(service);
    }
    public void setImage(byte image){
        image=image;
    }
}




